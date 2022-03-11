package com.ramirez.pos.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DecimalValidator implements ConstraintValidator<CustomDecimalConstraint, Double> {

	private static final String DOUBLE_PATTERN = "[0-9]+(\\.){0,1}[0-9]*";

	@Override
	public boolean isValid(Double value, ConstraintValidatorContext context) {
		if(value!= null) {
			Pattern pattern = Pattern.compile(DOUBLE_PATTERN);
			Matcher matcher = pattern.matcher(String.valueOf(value));
			return matcher.find();
		} else {
			return false;
		}
	}

}
