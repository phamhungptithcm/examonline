package com.ptit.examonline.validation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ptit.examonline.dto.AccountDTO;
import com.ptit.examonline.helper.HelperConst;

@Component
public class AccountDTOValidation implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AccountDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {

		ValidationUtils.rejectIfEmpty(errors, "username", "accountDTO.username.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "accountDTO.password.empty");
		ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "accountDTO.confirmPassword.empty");
		ValidationUtils.rejectIfEmpty(errors, "firstName", "accountDTO.firstName.empty");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "accountDTO.lastName.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "accountDTO.email.empty");
		ValidationUtils.rejectIfEmpty(errors, "phoneNum", "accountDTO.phoneNum.empty");
		ValidationUtils.rejectIfEmpty(errors, "accountStatusId", "accountDTO.accountStatusId.empty");
		ValidationUtils.rejectIfEmpty(errors, "accountPlanId", "accountDTO.accountPlanId.empty");

		AccountDTO accountDTO = (AccountDTO) object;

		Pattern patternEmail = Pattern.compile(HelperConst.REGULAR_EMAIL, Pattern.CASE_INSENSITIVE);
		if (!(patternEmail.matcher(accountDTO.getEmail()).matches())) {
			errors.rejectValue("email", "accountDTO.email.invalid");
		}
		
		Pattern patternPhone = Pattern.compile(HelperConst.REGULAR_PHONE, Pattern.CASE_INSENSITIVE);
		if (!(patternPhone.matcher(accountDTO.getPhoneNum()).matches())) {
			errors.rejectValue("phoneNum", "accountDTO.phoneNum.invalid");
		}

	}

}
