package com.me.spring.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.spring.pojo.BuyerUser;

public class BuyerUserValidator implements Validator{

	public boolean supports(Class aClass) {
		return aClass.equals(BuyerUser.class);
	}

	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.user", " UserName Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "error.invalid.phoneNumber",
				"Phone Number Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.email", "Email Required");
	}

}
