package com.ptit.examonline.helper;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HelperController {

	@Autowired
	protected HttpServletResponse response;

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	protected HttpSession session;

	@Autowired
	protected ServletContext servletContext;
	
	protected String viewUserPages(String view) {
		request.setAttribute("view", view);
		return "user/layout";
	}
	protected String viewAdminPages(String view) {
		request.setAttribute("view", view);
		return "admin/layout";
	}
	
	protected Cookie getCookie(String cookieName) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals(cookieName)) {
					return cookie;
				}
			}
		}
		return null;
	}
	
	protected String getCookieValue(String cookieName, String...defaulValue) {
		Cookie cookie = getCookie(cookieName);
		if(cookie == null) {
			return defaulValue[0];
		}
		return cookie.getValue();
	}
	protected void addCookie(Cookie cookie, int days) {
		cookie.setMaxAge(days*24*60*60*60);
		response.addCookie(cookie);
	}
	protected void addCookie(String cookieName, String cookieValue, int days) {
		Cookie cookie = new Cookie(cookieName, cookieValue);
		addCookie(cookie, days);
	}
	protected void removeCookie(String cookieName){
		this.addCookie(cookieName, "",0);
	}
	
}
