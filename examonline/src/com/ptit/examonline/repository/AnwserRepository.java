package com.ptit.examonline.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ptit.examonline.dao.AnwserDAO;
import com.ptit.examonline.entity.Anwser;


@Repository
@EnableTransactionManagement
public class AnwserRepository implements AnwserDAO{

	@Autowired
	SessionFactory factory;

	@Override
	public void insert(Anwser entity) {
		factory.getCurrentSession().save(entity);
		
	}

	@Override
	public void update(Anwser entity) {
		factory.getCurrentSession().update(entity);
		
	}

	@Override
	public void delete(Anwser entity) {
		factory.getCurrentSession().delete(entity);
		
	}

	@Override
	public void refresh(Anwser entity) {
		factory.getCurrentSession().refresh(entity);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Anwser> getAnswers() {
		String hql = "FROM Anwser";
		Query query = factory.getCurrentSession().createQuery(hql);
		return query.list();
	}
}
