package com.ptit.examonline.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "ACCOUNTS")
@DynamicUpdate

public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNTNUMBER")
	private Long accountNumber;
	
	@Column(name = "USERNAME")
	private String userName;
	
	@Column(name = "PASSWORD")
	private String password;
	
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
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ACCOUNTPLANID")
	private AccountPlan accountPlan;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ACCOUNTSTATUSID")
	private AccountStatus accountStatus;
	
	@OneToMany(mappedBy="account")
	private List<Exam> exams;
	

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSONID", referencedColumnName = "PERSONID")
    private Person person;
	
	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
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

	public AccountPlan getAccountPlan() {
		return accountPlan;
	}

	public void setAccountPlan(AccountPlan accountPlan) {
		this.accountPlan = accountPlan;
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

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}
	
}
