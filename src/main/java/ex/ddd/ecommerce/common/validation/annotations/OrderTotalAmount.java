package ex.ddd.ecommerce.common.validation.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import ex.ddd.ecommerce.common.validation.OrderTotalAmountImpl;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Constraint(validatedBy = OrderTotalAmountImpl.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OrderTotalAmount {
	String message() default "Sorry we can't validate your account right now, please contact the customer care";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
}
