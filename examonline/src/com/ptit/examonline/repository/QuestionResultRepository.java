package com.ptit.examonline.repository;

import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ptit.examonline.dao.QuestionResultDAO;
import com.ptit.examonline.entity.QuestionResult;

@Repository
@EnableTransactionManagement
public class QuestionResultRepository implements QuestionResultDAO {

	@Autowired
	SessionFactory factory;

	@Override
	public void insert(QuestionResult entity) {
		factory.getCurrentSession().save(entity);
	}

	@Override
	public void update(QuestionResult entity) {
		factory.getCurrentSession().merge(entity);

	}

	@Override
	public void delete(QuestionResult entity) {
		factory.getCurrentSession().delete(entity);

	}

	@Override
	public void refresh(QuestionResult entity) {
		factory.getCurrentSession().refresh(entity);

	}

	@Override
	public Set<QuestionResult> getQuestionResults() {
		String hql = "FROM QuestionResult";
		Query query = factory.getCurrentSession().createQuery(hql);
		return (Set<QuestionResult>) query.list();
	}
}
