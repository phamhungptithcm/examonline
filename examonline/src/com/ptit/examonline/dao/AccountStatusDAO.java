package com.ptit.examonline.dao;

import java.util.List;

import com.ptit.examonline.entity.AccountStatus;

public interface AccountStatusDAO {
	public void insert(AccountStatus entity) throws Exception;
	public void update(AccountStatus entity) throws Exception;
	public void delete(AccountStatus entity) throws Exception;
	public void refresh(AccountStatus entity) throws Exception;
	public List<AccountStatus> getAccountStatuses() throws Exception;
	public AccountStatus getAccountStatusById(Long accountStatusId) throws Exception;
	public AccountStatus getAccountStatusByCode(String statusCode) throws Exception;
}
