package com.ptit.examonline.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ptit.examonline.dao.QuestionDAO;
import com.ptit.examonline.service.QuestionService;

@Component
public class QuestionServiceImp implements QuestionService{
	
	@Autowired
	private QuestionDAO questionDAO;
	
	

}
