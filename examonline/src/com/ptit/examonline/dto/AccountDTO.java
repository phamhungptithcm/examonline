package com.ptit.examonline.dto;

import java.io.Serializable;

public class AccountDTO implements Serializable{
	
	private static final long serialVersionUID = -7297816908815414032L;
	
	private Long accountNumber;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNum;
	private String accountStatus;
	private String accountPlan;
	private Long accountStatusId;
	private Long accountPlanId;
	
	
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getAccountPlan() {
		return accountPlan;
	}
	public void setAccountPlan(String accountPlan) {
		this.accountPlan = accountPlan;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getAccountStatusId() {
		return accountStatusId;
	}
	public void setAccountStatusId(Long accountStatusId) {
		this.accountStatusId = accountStatusId;
	}
	public Long getAccountPlanId() {
		return accountPlanId;
	}
	public void setAccountPlanId(Long accountPlanId) {
		this.accountPlanId = accountPlanId;
	}
	
}
