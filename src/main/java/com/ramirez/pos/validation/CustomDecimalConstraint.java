package com.ramirez.pos.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DecimalValidator.class)
public @interface CustomDecimalConstraint {

	String message() default "Invalid Data";

	Class<?>[] groups() default {};

	public abstract Class<? extends Payload>[] payload() default {};
}
