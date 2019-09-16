package com.ptit.examonline.repository;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ptit.examonline.dao.QuestionDAO;
import com.ptit.examonline.entity.Question;


@Repository
@EnableTransactionManagement
public class QuestionRepository implements QuestionDAO{

	@Autowired
	SessionFactory factory;

	@Override
	public void insert(Question entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Question entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Question entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh(Question entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Question> getQuestions() {
		// TODO Auto-generated method stub
		return null;
	}

}
