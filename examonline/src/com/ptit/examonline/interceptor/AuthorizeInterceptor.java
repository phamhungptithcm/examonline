package com.ptit.examonline.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ptit.examonline.dto.LoginInfoDTO;

public class AuthorizeInterceptor extends HandlerInterceptorAdapter {

	@SuppressWarnings("unused")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String cpath = request.getContextPath();
		String requestAction = request.getRequestURI().replace(cpath, "");
		HttpSession session = request.getSession();
		
		LoginInfoDTO loginInfoDTO = (LoginInfoDTO) session.getAttribute("user");

		if (loginInfoDTO == null) {
			session.setAttribute("requestAction", requestAction);
			response.sendRedirect(cpath + "/account/account-log.htm");
			return false;
		}
		return true;
	}
}
