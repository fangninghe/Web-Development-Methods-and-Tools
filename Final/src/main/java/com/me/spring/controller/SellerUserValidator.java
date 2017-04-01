package com.me.spring.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.me.spring.pojo.SellerUser;


public class SellerUserValidator implements Validator {

	public boolean supports(Class aClass) {
		return aClass.equals(SellerUser.class);
	}

	public void validate(Object obj, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.user", " UserName Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.invalid.name", "Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "error.invalid.gender", "Gender Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ssn", "error.invalid.ssn", "SSN Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "error.invalid.phoneNumber", "Phone Number Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "error.invalid.address", "Address Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.email", "Email Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "aboutMe", "error.invalid.aboutMe", "Self Discription Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "catagory", "error.invalid.catagory","Service Field Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "error.invalid.price","Price Field Required");
	}
}
