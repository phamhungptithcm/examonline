package com.ptit.examonline.dao;

import java.util.List;

import com.ptit.examonline.entity.Question;

public interface QuestionDAO {
	public void insert(Question entity);

	public void update(Question entity);

	public void delete(Question entity);

	public void refresh(Question entity);

	public List<Question> getQuestions();

	public List<Question> getQuestionsRandom(Integer level);

	public Question getQuestionByQuestionId(Long questionId);

	public List<Question> getQuestions(int pageNo, int pageSize);

	public List<Question> getQuestions(int pageNo, int pageSize, int level);
}
