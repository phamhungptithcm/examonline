package com.ptit.examonline.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.examonline.dto.AccountMessage;
import com.ptit.examonline.dto.LoginInfoDTO;
import com.ptit.examonline.dto.NewAccountInfoDTO;
import com.ptit.examonline.dto.PersonInfoDTO;
import com.ptit.examonline.entity.Account;

@Transactional
@Service
public interface AccountService {
	public AccountMessage signin(LoginInfoDTO loginInfoDTO) throws Exception;
	public AccountMessage signup(NewAccountInfoDTO account) throws Exception;
	public PersonInfoDTO setPersonInfo(String userName) throws Exception;
	public AccountMessage fogotPassword(String email) throws Exception;
	public AccountMessage resetPassword(String password, String email) throws Exception;
	public AccountMessage changePassword(String userName, String password) throws Exception;
}
