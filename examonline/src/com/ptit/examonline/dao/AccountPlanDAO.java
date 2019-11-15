package com.ptit.examonline.dao;

import java.util.List;

import com.ptit.examonline.entity.AccountPlan;

public interface AccountPlanDAO {
	public void insert(AccountPlan entity) throws Exception;
	public void update(AccountPlan entity) throws Exception;
	public void delete(AccountPlan entity) throws Exception;
	public void refresh(AccountPlan entity) throws Exception; 
	public List<AccountPlan> getAccountPlans() throws Exception;
	public AccountPlan getAccountPlanById(Long accountPlanId) throws Exception;
	public AccountPlan getAccountPlanByCode(String planCode);
	public List<AccountPlan> getAccountPlans(int pageNo, int pageSize);
}
