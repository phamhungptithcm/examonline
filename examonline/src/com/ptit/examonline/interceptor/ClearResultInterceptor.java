package com.ptit.examonline.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ptit.examonline.service.ResultService;

public class ClearResultInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	ResultService resultService;

	@SuppressWarnings("unused")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		resultService.clear();
		return true;
	}
}
