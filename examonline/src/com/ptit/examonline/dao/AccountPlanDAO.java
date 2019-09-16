package com.ptit.examonline.dao;

import java.util.Set;

import com.ptit.examonline.entity.AccountPlan;

public interface AccountPlanDAO {
	public void insert(AccountPlan entity) throws Exception;
	public void update(AccountPlan entity) throws Exception;
	public void delete(AccountPlan entity) throws Exception;
	public void refresh(AccountPlan entity) throws Exception; 
	public Set<AccountPlan> getAccountPlans() throws Exception;
	public AccountPlan getAccountPlanByPlanCode(String code) throws Exception;
}
