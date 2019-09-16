package com.ptit.examonline.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name="ACCOUNTPLANS")
@DynamicUpdate(value=true)
public class AccountPlan implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNTPLANID", nullable = false)
	private Long accountPlanId;
	
	@Column(name = "PLANCODE", nullable = false)
	private String planCode;
	
	@Column(name = "SHORTDESCRIPTION", nullable = false)
	private String shortDescription;
	
	@Column(name = "CREATEDBY", nullable = false)
	private String createdBy;

	@Column(name = "DATECREATED", nullable = false)
	@CreationTimestamp
	private Timestamp dateCreated;

	@Column(name = "DATEMODIFIED", nullable = false)
	@UpdateTimestamp
	private Timestamp dateModified;

	@Column(name = "MODIFIEDBY", nullable = false)
	private String modifiedBy;
	
	@OneToMany(mappedBy="accountPlan")
	Set<Account> accounts;

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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Timestamp getDateModified() {
		return dateModified;
	}

	public void setDateModified(Timestamp dateModified) {
		this.dateModified = dateModified;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	
	
}
