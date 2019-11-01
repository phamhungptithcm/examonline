package com.ptit.examonline.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.examonline.dto.AccountDTO;
import com.ptit.examonline.dto.LoginInfoDTO;
import com.ptit.examonline.dto.MessageChecking;
import com.ptit.examonline.dto.PersonDTO;
import com.ptit.examonline.entity.Account;

@Transactional
@Service
public interface AccountService {
	public MessageChecking signin(LoginInfoDTO loginInfoDTO) throws Exception;

	public MessageChecking signup(AccountDTO account) throws Exception;

	public PersonDTO setPersonInfo(String userName) throws Exception;

	public MessageChecking fogotPassword(String email) throws Exception;

	public MessageChecking resetPassword(String password, String email) throws Exception;

	public MessageChecking changePassword(String userName, String password) throws Exception;

	public Account getCurrentAccount() throws Exception;

	public Account getAccount(String userName) throws Exception;

	public List<Account> getAccounts() throws Exception;

	public AccountDTO getAccountByUsername(String username) throws Exception;

	public AccountDTO delete(Long accountNumber) throws Exception;

	public AccountDTO getAccountByAccountNumber(Long accountNumber) throws Exception;

	public MessageChecking updateAccount(AccountDTO accountDTO) throws Exception;

	public MessageChecking addAnNewAccount(AccountDTO accountDTO) throws Exception;
}
