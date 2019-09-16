package com.ptit.examonline.repository;

import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ptit.examonline.dao.PersonDAO;
import com.ptit.examonline.entity.Person;


@Repository
@EnableTransactionManagement
public class PersonRepository implements PersonDAO{
	
	@Autowired
	SessionFactory factory;

	@Override
	public void insert(Person entity) {
		factory.getCurrentSession().save(entity);
	}

	@Override
	public void update(Person entity) {
		factory.getCurrentSession().merge(entity);
	}

	@Override
	public void delete(Person entity) {
		factory.getCurrentSession().delete(entity);
	}

	@Override
	public void refresh(Person entity) {
		factory.getCurrentSession().refresh(entity);
	}

	@Override
	public Set<Person> getPersons() {
		String hql = "FROM Person";
		Query query = factory.getCurrentSession().createQuery(hql);
		return (Set<Person>) query.list();
	}

	@Override
	public Person getPersonById(Long id) {
		return factory.getCurrentSession().get(Person.class, id);
	}
	
	
}
