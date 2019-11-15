package com.ptit.examonline.dao;

import java.util.List;

import com.ptit.examonline.entity.Person;

public interface PersonDAO {
	public void insert(Person entity);
	public void update(Person entity);
	public void delete(Person entity);
	public void refresh(Person entity);
	public List<Person> getPersons();
	public Person getPersonById(Long id);
	public List<Person> getPersons(int pageNo, int pageSize);
}
