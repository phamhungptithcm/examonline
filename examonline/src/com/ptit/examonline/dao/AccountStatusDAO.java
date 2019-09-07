package com.ptit.examonline.dao;

import java.util.Set;

import com.ptit.examonline.entity.AccountStatus;

public interface AccountStatusDAO {
	public void insert(AccountStatus entity);
	public void update(AccountStatus entity);
	public void delete(AccountStatus entity);
	public void refresh(AccountStatus entity);
	public Set<AccountStatus> getAccountStatuses();
}
