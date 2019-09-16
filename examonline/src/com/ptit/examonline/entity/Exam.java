package com.ptit.examonline.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name="EXAMS")
@DynamicUpdate(value=true)
public class Exam implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EXAMID", nullable = false)
	private Long examId;
	
	@Column(name = "ANWSERORDER", nullable = false)
	private String anwserOrder;
	
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
	
	@ManyToMany(mappedBy = "exams")
    private Set<Question> questions = new HashSet<>();	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ACCOUNTNUMBER", nullable = false)
	private Account account;

	public Long getExamId() {
		return examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

	public String getAnwserOrder() {
		return anwserOrder;
	}

	public void setAnwserOrder(String anwserOrder) {
		this.anwserOrder = anwserOrder;
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

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
