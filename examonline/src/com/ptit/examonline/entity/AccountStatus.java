package com.ptit.examonline.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

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
@Table(name="ACCOUNTSTATUSES")
@DynamicUpdate(value=true)
public class AccountStatus implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNTSTATUSID")
	private Long accountStatusId;
	
	@Column(name = "ACCOUNTSTATUSCODE")
	private String accoutStatusCode;
	
	@Column(name = "SHORTDESCRIPTION")
	private String shortDescription;
	
	@Column(name = "ISACTIVE")
	private boolean isActive;
	
	@Column(name = "CREATEDBY")
	private String createdBy;

	@Column(name = "DATECREATED")
	@CreationTimestamp
	private Timestamp dateCreated;

	@Column(name = "DATEMODIFIED")
	@UpdateTimestamp
	private Timestamp dateModified;

	@Column(name = "MODIFIEDBY")
	private String modifiedBy;
	
	@OneToMany(mappedBy="accountStatus")
	List<Account> accounts;

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

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
}
