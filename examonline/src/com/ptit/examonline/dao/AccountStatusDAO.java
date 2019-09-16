package com.ptit.examonline.dao;

import java.util.Set;

import com.ptit.examonline.entity.AccountStatus;

public interface AccountStatusDAO {
	public void insert(AccountStatus entity) throws Exception;
	public void update(AccountStatus entity) throws Exception;
	public void delete(AccountStatus entity) throws Exception;
	public void refresh(AccountStatus entity) throws Exception;
	public Set<AccountStatus> getAccountStatuses() throws Exception;
	public AccountStatus getAccountStatusByStatusCode(String code) throws Exception;
}
