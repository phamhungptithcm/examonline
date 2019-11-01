package com.ptit.examonline.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name="QUESTIONS")
@DynamicUpdate(value=true)
public class Question implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "QUESTIONID")
	private Long questionId;
	
	@Column(name = "CONTENT")
	private String content;
	
	@Column(name = "LEVEL")
	private Integer level;
	
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
	
	@OneToMany(mappedBy="question", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Anwser> anwsers;
	
	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
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

	public List<Anwser> getAnwsers() {
		return anwsers;
	}

	public void setAnwsers(List<Anwser> anwsers) {
		this.anwsers = anwsers;
	}
}
