package com.ptit.examonline.dao;

import java.util.Set;

import com.ptit.examonline.entity.AccountPlan;

public interface AccountPlanDAO {
	public void insert(AccountPlan entity);
	public void update(AccountPlan entity);
	public void delete(AccountPlan entity);
	public void refresh(AccountPlan entity);
	public Set<AccountPlan> getAccountPlans();
}
