package com.ptit.examonline.dao;

import java.util.Set;

import com.ptit.examonline.entity.Question;

public interface QuestionDAO {
	public void insert(Question entity);
	public void update(Question entity);
	public void delete(Question entity);
	public void refresh(Question entity);
	public Set<Question> getQuestions();
}
