package com.ptit.examonline.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.examonline.entity.Question;

@Transactional
@Service
public interface QuestionService {
	
	public List<Question> getExam(Integer level) throws Exception;

	public List<Question> getQuestions(int pageNo, int pageSize) throws Exception;
	public List<Question> getQuestions() throws Exception;

	public Question getQuestion(Long questionId) throws Exception;

	public boolean updateQuestion(Question question) throws Exception;

	public boolean saveQuestion(Question question) throws Exception;

	public boolean deleteQuestion(Long questionId) throws Exception;
}
