package com.ptit.examonline.dto;

import java.io.Serializable;

public class LoginInfoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	private boolean isAdmin;
	private Boolean remember;
	
	public LoginInfoDTO() {
		super();
	}
	public LoginInfoDTO(String userName, String password, Boolean remember) {
		super();
		this.userName = userName;
		this.password = password;
		this.remember = remember;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getRemember() {
		return remember;
	}
	public void setRemember(Boolean remember) {
		this.remember = remember;
	}
	public boolean getIsAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
