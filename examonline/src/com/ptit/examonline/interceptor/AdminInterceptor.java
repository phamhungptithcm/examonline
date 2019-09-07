package com.ptit.examonline.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ptit.examonline.dto.LoginInfoDTO;
import com.ptit.examonline.entity.Account;
import com.ptit.examonline.service.AccountService;

public class AdminInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	private AccountService accountService;
	
	@SuppressWarnings("unused")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String cpath = request.getContextPath();
		String requestAction = request.getRequestURI().replace(cpath, "");
		HttpSession session = request.getSession();
		
		LoginInfoDTO loginInfoDTO = (LoginInfoDTO) session.getAttribute("user");
		
		Account user = accountService.getAccountByUserName(loginInfoDTO.getUserName());
		
		if(loginInfoDTO == null) {
			session.setAttribute("requestAction", requestAction);
			response.sendRedirect(cpath + "/account/login.php");
			return false;
		}
		else {
			if(user.getAccountPlan().getPlanCode().equals("T")) {
				session.setAttribute("requestAction", requestAction);
				response.sendRedirect(cpath + "/account/login.php");
				return false;
			}
		}
		return true;
	}
}
