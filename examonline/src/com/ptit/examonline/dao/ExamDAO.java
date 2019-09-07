package com.ptit.examonline.dao;

import java.util.Set;

import com.ptit.examonline.entity.Exam;

public interface ExamDAO {
	public void insert(Exam entity);
	public void update(Exam entity);
	public void delete(Exam entity);
	public void refresh(Exam entity);
	public Set<Exam> getExams();
}
