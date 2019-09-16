package com.ptit.examonline.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ptit.examonline.dao.ExamDAO;
import com.ptit.examonline.dao.QuestionDAO;
import com.ptit.examonline.entity.Exam;
import com.ptit.examonline.service.ExamService;
import com.ptit.examonline.service.QuestionService;

@Component
public class ExamServiceImp implements ExamService{
	
	@Autowired
	private ExamDAO examDAO;
	
	@Autowired
	private QuestionService questionService;
	
	@Override
	public Exam getExam(Integer level) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
