package com.ptit.examonline.repository;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptit.examonline.dao.AccountStatusDAO;
import com.ptit.examonline.entity.AccountStatus;

@Repository
public class AccountStatusRepository implements AccountStatusDAO{

	@Autowired
	SessionFactory factory;

	@Override
	public void insert(AccountStatus entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(AccountStatus entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(AccountStatus entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh(AccountStatus entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<AccountStatus> getAccountStatuses() {
		// TODO Auto-generated method stub
		return null;
	}
}
