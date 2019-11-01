package com.ptit.examonline.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ptit.examonline.service.AccountService;

public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private AccountService accountService;

	@SuppressWarnings("unused")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String cpath = request.getContextPath();
		String requestAction = request.getRequestURI().replace(cpath, "");
		HttpSession session = request.getSession();

		/*LoginInfoDTO loginInfoDTO = (LoginInfoDTO) session.getAttribute("user");

		if (loginInfoDTO == null) {
			response.sendRedirect(cpath + "/account/account-log.htm");
			return false;
		} else {
			if (loginInfoDTO.getIsAdmin()) {
				response.sendRedirect(cpath + "/account/account-log.htm");
				return false;
			}
		}
		response.sendRedirect(cpath + "/admin/home/index.htm");*/
		return true;
	}
}
