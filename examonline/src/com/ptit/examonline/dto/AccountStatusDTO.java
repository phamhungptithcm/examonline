package com.ptit.examonline.dto;

import java.io.Serializable;

public class AccountStatusDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long accountStatusId;
	private String accountStatusCode;
	private String shortDescription;
	
	
	
	public AccountStatusDTO() {
		super();
	}
	public AccountStatusDTO(Long accountStatusId, String accountStatusCode, String shortDescription) {
		super();
		this.accountStatusId = accountStatusId;
		this.accountStatusCode = accountStatusCode;
		this.shortDescription = shortDescription;
	}
	public Long getAccountStatusId() {
		return accountStatusId;
	}
	public void setAccountStatusId(Long accountStatusId) {
		this.accountStatusId = accountStatusId;
	}
	public String getAccountStatusCode() {
		return accountStatusCode;
	}
	public void setAccountStatusCode(String accountStatusCode) {
		this.accountStatusCode = accountStatusCode;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	
	

}
