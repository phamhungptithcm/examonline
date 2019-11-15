package com.ptit.examonline.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ptit.examonline.entity.Question;

@Component
public class QuestionValidation implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Question.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "content", "question.content.empty");
		ValidationUtils.rejectIfEmpty(errors, "level", "question.level.empty");
		ValidationUtils.rejectIfEmpty(errors, "anwsers[0].anwserId", "question.anwsers[0].content.empty");
		ValidationUtils.rejectIfEmpty(errors, "anwsers[1].anwserId", "question.anwsers[1].content.empty");
		ValidationUtils.rejectIfEmpty(errors, "anwsers[2].anwserId", "question.anwsers[2].content.empty");
		ValidationUtils.rejectIfEmpty(errors, "anwsers[3].anwserId", "question.anwsers[3].content.empty");
	}

}
