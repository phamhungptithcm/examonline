package com.ptit.examonline.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.examonline.dao.AccountDAO;
import com.ptit.examonline.dto.AccountMessage;
import com.ptit.examonline.dto.LoginInfoDTO;
import com.ptit.examonline.dto.NewAccountInfoDTO;
import com.ptit.examonline.entity.Account;
import com.ptit.examonline.helper.Helper;

@Transactional
@Service
public class AccountService extends Helper{
	
	@Autowired
	private AccountDAO accountDAO;

	public AccountMessage signin(HttpSession session,LoginInfoDTO loginInfoDTO) throws Exception{
		Account account = accountDAO.getAccount(loginInfoDTO.getUserName());
		
		AccountMessage message = new AccountMessage();
		if(account == null) {
			message.setMessage("Account information is not correct. Please check your username/password again!");
			message.setStatus(false);
		} else if(account.getAccountStatus().getAccoutStatusCode().equals("A")) {
			message.setMessage("This account is not actived. Please contact administrator!");
			message.setStatus(false);
		} else if(!loginInfoDTO.getPassword().equals(account.getPassword())) {
			message.setMessage("Account information is not correct. Please check your username/password again!");
			message.setStatus(false);
		} else {
			session.setAttribute("user", account);
			
			message.setMessage("Succcessfuly");
			message.setStatus(true);
		}
		return message;
	}

	public Account getAccountByUserName(String userName) {
		return accountDAO.getAccount(userName);
	}

	public AccountMessage signup(NewAccountInfoDTO account) throws Exception{
		AccountMessage message = new AccountMessage();
		
		Account user = accountDAO.getAccount(account.getUserName());
		if(user != null) {
			message.setMessage("The username already exists!");
			message.setStatus(false);
		}
		else {
			Account newAccount = new Account();
			newAccount.setUserName(account.getUserName());
			newAccount.setPassword(encryption(account.getPassword()));
//			newAccount.setAccountStatus(accountStatus);
		}
		
		return message;
	}
}
