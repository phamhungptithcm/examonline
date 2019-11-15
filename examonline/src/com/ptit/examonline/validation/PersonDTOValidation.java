package com.ptit.examonline.validation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ptit.examonline.dto.PersonDTO;
import com.ptit.examonline.helper.HelperConst;

@Component
public class PersonDTOValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return PersonDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "gender", "personDTO.gender.empty");
		ValidationUtils.rejectIfEmpty(errors, "firstName", "personDTO.firstName.empty");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "personDTO.lastName.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "personDTO.email.empty");
		ValidationUtils.rejectIfEmpty(errors, "phoneNum", "personDTO.phoneNum.empty");
		ValidationUtils.rejectIfEmpty(errors, "address", "personDTO.address.empty");
		PersonDTO personDTO = (PersonDTO) object;

		Pattern patternEmail = Pattern.compile(HelperConst.REGULAR_EMAIL, Pattern.CASE_INSENSITIVE);
		if (!(patternEmail.matcher(personDTO.getEmail()).matches())) {
			errors.rejectValue("email", "personDTO.email.invalid");
		}
		
		Pattern patternPhone = Pattern.compile(HelperConst.REGULAR_PHONE, Pattern.CASE_INSENSITIVE);
		if (!(patternPhone.matcher(personDTO.getPhoneNum()).matches())) {
			errors.rejectValue("phoneNum", "personDTO.phoneNum.invalid");
		}
	}

}
