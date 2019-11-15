package com.ptit.examonline.helper;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ptit.examonline.dao.AccountDAO;
import com.ptit.examonline.dto.LoginInfoDTO;
import com.ptit.examonline.dto.PersonDTO;
import com.ptit.examonline.entity.Account;
import com.ptit.examonline.entity.Person;

@Component
public class HelperService {
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private HttpSession session;
	
	
	public Account getCurrentAccount() throws Exception {
		LoginInfoDTO loginInfoDTO = (LoginInfoDTO) session.getAttribute("user");
		
		return accountDAO.getAccount(loginInfoDTO.getUserName());
	}
	
}
