package com.ptit.examonline.dao;

import java.util.Set;

import com.ptit.examonline.entity.QuestionResult;

public interface QuestionResultDAO {
	public void insert(QuestionResult entity);
	public void update(QuestionResult entity);
	public void delete(QuestionResult entity);
	public void refresh(QuestionResult entity);
	public Set<QuestionResult> getQuestionResults();
}
