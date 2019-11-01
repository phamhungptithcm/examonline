package com.ptit.examonline.dto;

import java.io.Serializable;

public class AccountPlanDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long accountPlanId;
	private String planCode;
	private String shortDescription;
	
	public AccountPlanDTO() {
		super();
	}
	public AccountPlanDTO(Long accountPlanId, String planCode, String shortDescription) {
		super();
		this.accountPlanId = accountPlanId;
		this.planCode = planCode;
		this.shortDescription = shortDescription;
	}
	public Long getAccountPlanId() {
		return accountPlanId;
	}
	public void setAccountPlanId(Long accountPlanId) {
		this.accountPlanId = accountPlanId;
	}
	public String getPlanCode() {
		return planCode;
	}
	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
