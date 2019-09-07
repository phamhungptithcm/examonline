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


@Entity
@Table(name="ACCOUNTSTATUSES")
public class AccountStatus implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNTSTATUSID", nullable = false)
	private Long accountStatusId;
	
	@Column(name = "ACCOUNTSTATUSCODE", nullable = false)
	private String accoutStatusCode;
	
	@Column(name = "SHORTDESCRIPTION", nullable = false)
	private String shortDescription;
	
	@Column(name = "CREATEDBY", nullable = false)
	private String createdBy;

	@Column(name = "DATECREATED", nullable = false)
	private Timestamp dateCreated;

	@Column(name = "DATEMODIFIED", nullable = false)
	private Timestamp dateModified;

	@Column(name = "MODIFIEDBY", nullable = false)
	private String modifiedBy;
	
	@OneToMany(mappedBy="accountStatus")
	Set<Account> accounts;

	public Long getAccountStatusId() {
		return accountStatusId;
	}

	public void setAccountStatusId(Long accountStatusId) {
		this.accountStatusId = accountStatusId;
	}

	public String getAccoutStatusCode() {
		return accoutStatusCode;
	}

	public void setAccoutStatusCode(String accoutStatusCode) {
		this.accoutStatusCode = accoutStatusCode;
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
