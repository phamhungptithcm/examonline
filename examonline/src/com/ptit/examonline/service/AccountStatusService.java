package com.ptit.examonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.examonline.dao.AccountDAO;
import com.ptit.examonline.dao.AccountStatusDAO;

@Transactional
@Service
public class AccountStatusService {
	
	@Autowired
	private AccountStatusDAO accountStatusDAO;
}
