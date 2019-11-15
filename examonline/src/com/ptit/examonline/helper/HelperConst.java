package com.ptit.examonline.helper;

import java.util.HashMap;
import java.util.Map;

public class HelperConst {
	private static final String JAVASERVLET = "Java Servlet";
	private static final String JAVACORE = "Java Core";
	private static final String SPRINGMVC = "Spring MVC";
	public static final String ACCOUNTNOTFOUND = "Account information is not correct. Please check your username/password again!";
	public static final String ACCOUNTNOTACTIVE = "This account is not actived. Please contact administrator!";
	public static final String ACCOUTNEXISTED = "The username already exists!";
	
	public static final String REGULAR_EMAIL = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
	public static final String REGULAR_PHONE = "^0\\d{9,10}$";
	
	private static Map<Integer, String> map = new HashMap<Integer, String>();

	public HelperConst() {
		map.put(2, JAVASERVLET);
		map.put(1, JAVACORE);
		map.put(3, SPRINGMVC);
	}
	
	public static Map<Integer, String> getSubjects() {
		return map;
	}
	public static String getSubject(Integer key) {
		return map.get(key);
	}
}
