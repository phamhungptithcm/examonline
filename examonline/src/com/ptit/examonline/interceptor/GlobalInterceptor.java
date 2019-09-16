package com.ptit.examonline.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ptit.examonline.dao.AccountDAO;
import com.ptit.examonline.dto.LoginInfoDTO;
import com.ptit.examonline.dto.PersonInfoDTO;
import com.ptit.examonline.entity.Account;
import com.ptit.examonline.entity.Person;
import com.ptit.examonline.service.AccountService;


public class GlobalInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private HttpSession session;
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		LoginInfoDTO loginInfoDTO = (LoginInfoDTO) session.getAttribute("user");
		if(loginInfoDTO != null) {
				PersonInfoDTO infoDTO = accountService.setPersonInfo(loginInfoDTO.getUserName());
				request.setAttribute("personDetails", infoDTO);
		}
	}
}
