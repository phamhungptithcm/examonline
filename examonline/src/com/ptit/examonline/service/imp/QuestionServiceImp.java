package com.ptit.examonline.service.imp;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ptit.examonline.dao.QuestionDAO;
import com.ptit.examonline.entity.Question;
import com.ptit.examonline.service.QuestionService;

@Component
public class QuestionServiceImp implements QuestionService{
	
	@Autowired
	private QuestionDAO questionDAO;

	@Override
	public List<Question> getExam(Integer level) throws Exception {
		List<Question> questions = questionDAO.getQuestionsRandom(level);
		return questions;
	}
	
	

}
