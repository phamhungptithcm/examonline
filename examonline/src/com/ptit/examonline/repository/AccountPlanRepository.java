package com.ptit.examonline.repository;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptit.examonline.dao.AccountPlanDAO;
import com.ptit.examonline.entity.AccountPlan;

@Repository
public class AccountPlanRepository implements AccountPlanDAO{
	
	@Autowired
	SessionFactory factory;

	@Override
	public void insert(AccountPlan entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(AccountPlan entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(AccountPlan entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh(AccountPlan entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<AccountPlan> getAccountPlans() {
		// TODO Auto-generated method stub
		return null;
	}

}
