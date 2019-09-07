package com.ptit.examonline.repository;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptit.examonline.dao.PersonDAO;
import com.ptit.examonline.entity.Person;

@Repository
public class PersonRepository implements PersonDAO{
	
	@Autowired
	SessionFactory factory;

	@Override
	public void insert(Person entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Person entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Person entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh(Person entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Person> getPersons() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
