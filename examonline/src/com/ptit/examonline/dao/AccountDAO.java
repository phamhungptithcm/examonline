package com.ptit.examonline.dao;

import java.util.List;

import com.ptit.examonline.entity.Account;

public interface AccountDAO {
	public void insert(Account entity);
	public void update(Account entity);
	public void delete(Account entity);
	public void refresh(Account entity);
	public List<Account> getAccounts();
	public Account getAccount(String userName);
	public Account getAcountByEmail(String email);
	public Account getAccountByAccountNumber(Long accountNumber);
	public Account getAccountByUserName(String username);
	public List<Account> getAccounts(int pageNo, int pageSize);
}
