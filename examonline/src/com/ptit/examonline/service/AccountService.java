package com.ptit.examonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.examonline.dao.AccountDAO;
import com.ptit.examonline.entity.Account;

@Transactional
@Service
public class AccountService {
	
	@Autowired
	private AccountDAO accountDAO;

	public Account getAccountByUserName(String userName) {
		Account account = new Account();
		return account;
	}
}
