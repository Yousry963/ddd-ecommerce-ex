package ex.ddd.ecommerce.common.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import ex.ddd.ecommerce.common.validation.annotations.TrueBooleanValue;

public class TrueBooleanValueImpl implements ConstraintValidator<TrueBooleanValue, Boolean> {

	@Override
	public boolean isValid(Boolean value, ConstraintValidatorContext context) {

		return value;
	}

}
