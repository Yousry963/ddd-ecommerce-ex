package ex.ddd.ecommerce.common.validation;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import ex.ddd.ecommerce.common.validation.annotations.OrderTotalAmount;
import ex.ddd.ecommerce.ordermanagement.domain.OrderDomain;

public class OrderTotalAmountImpl implements ConstraintValidator<OrderTotalAmount, OrderDomain> {

	@Override
	public boolean isValid(OrderDomain value, ConstraintValidatorContext context) {

		if (value == null) {
			return true;
		}

		if (!(value instanceof OrderDomain)) {
			throw new IllegalArgumentException(
					"Illegal method signature, " + "expected parameter of type Cart.");
		}

		Optional<Long> totalAmountOP = value.getLineItems().stream().map(x -> x.getPrice()).reduce(Long::sum);

		long totalAmount = totalAmountOP.get();
		
		if (totalAmount < 100) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("min order value is 100").addConstraintViolation();
			return false;
		} else if (totalAmount > 1500) {
			return false;
		}

		return true;
	}

}
