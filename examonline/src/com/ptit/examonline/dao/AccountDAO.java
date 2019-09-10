package com.ptit.examonline.dao;

import java.util.Set;

import com.ptit.examonline.entity.Account;

public interface AccountDAO {
	public void insert(Account entity);
	public void update(Account entity);
	public void delete(Account entity);
	public void refresh(Account entity);
	public Set<Account> getAccounts();
	public Account getAccount(String userName);
}
