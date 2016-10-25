package com.realdolmen.course.web.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.realdolmen.course.web.controller.AccountNumber;

public class AccountNumberValidator implements ConstraintValidator<ValidAccountNumber, AccountNumber>{

	@Override
	public void initialize(ValidAccountNumber constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(AccountNumber value, ConstraintValidatorContext context) {
		long rest = value.getNumber() % 97;
		return (rest == 0 || rest == value.getChecknumber());
	}

}
