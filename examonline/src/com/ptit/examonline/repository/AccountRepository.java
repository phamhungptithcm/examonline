package com.ptit.examonline.repository;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptit.examonline.dao.AccountDAO;
import com.ptit.examonline.entity.Account;

@Repository
public class AccountRepository implements AccountDAO{
	
	@Autowired
	SessionFactory factory;
	
	@Override
	public void insert(Account entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Account entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Account entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh(Account entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Account> getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}


}
