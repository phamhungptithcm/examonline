package com.ptit.examonline.repository;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptit.examonline.dao.ExamDAO;
import com.ptit.examonline.entity.Exam;

@Repository
public class ExamRepository implements ExamDAO{

	@Autowired
	SessionFactory factory;

	@Override
	public void insert(Exam entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Exam entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Exam entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh(Exam entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Exam> getExams() {
		// TODO Auto-generated method stub
		return null;
	}
}
