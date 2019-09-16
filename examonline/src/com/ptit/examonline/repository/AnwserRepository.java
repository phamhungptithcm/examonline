package com.ptit.examonline.repository;

import java.util.Set;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Anwser entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Anwser entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh(Anwser entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Anwser> getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}
}
