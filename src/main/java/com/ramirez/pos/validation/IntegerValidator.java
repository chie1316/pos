package com.ramirez.pos.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IntegerValidator implements ConstraintValidator<CustomIntegerConstraint, Integer> {

	private static final String INTEGER_PATTERN = "\\d+";

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		if (value != null) {
			Pattern pattern = Pattern.compile(INTEGER_PATTERN);
			Matcher matcher = pattern.matcher(String.valueOf(value));
			return matcher.find();
		} else {
			return false;
		}
	}

}
