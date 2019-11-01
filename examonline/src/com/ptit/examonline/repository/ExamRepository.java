package com.ptit.examonline.repository;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ptit.examonline.dao.ExamDAO;
import com.ptit.examonline.entity.Exam;


@Repository
@EnableTransactionManagement
public class ExamRepository implements ExamDAO{

	@Autowired
	SessionFactory factory;

	@Override
	public void insert(Exam entity) {
		factory.getCurrentSession().save(entity);
	}

	@Override
	public void update(Exam entity) {
		factory.getCurrentSession().merge(entity);
		
	}

	@Override
	public void delete(Exam entity) {
		factory.getCurrentSession().delete(entity);
		
	}

	@Override
	public void refresh(Exam entity) {
		factory.getCurrentSession().refresh(entity);
		
	}

	@Override
	public List<Exam> getExams() {
		String hql = "FROM Exam";
		Query query = factory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public List<Exam> getExamsByUsername(String username) {
		String hql = "FROM Exam e WHERE e.account.userName=:username";
		Query query = factory.getCurrentSession().createQuery(hql);
		query.setParameter("username", username);
		return query.list();
	}

	@Override
	public Exam getExamsByExamId(Long examId) {
		String hql = "FROM Exam e WHERE e.examId=:examId";
		Query query = factory.getCurrentSession().createQuery(hql);
		query.setParameter("examId", examId);
		return (Exam) query.uniqueResult();
	}
}
