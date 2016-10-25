package com.realdolmen.course.web.validators;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = AccountNumberValidator.class)
public @interface ValidAccountNumber {
	String message() default "Why U No Give Valid Shit????";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
