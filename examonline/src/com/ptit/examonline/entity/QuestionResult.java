package com.ptit.examonline.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="QUESTION_RESULT")
@DynamicUpdate(value=true)
public class QuestionResult {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "QUESTIONRESULTID")
	private Long questionResultId;
	
	@Column(name = "ANWSERORDER")
	private String answerOrder;
	
	@Column(name = "ANWSERID")
	private Long answerId;
	
	@Column(name = "QUESTIONID")
	private Long questionId;
	
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
	
	@ManyToOne
	@JoinColumn(name="EXAMID")
	private Exam exam;

	public Long getQuestionResultId() {
		return questionResultId;
	}

	public void setQuestionResultId(Long questionResultId) {
		this.questionResultId = questionResultId;
	}

	public String getAnswerOrder() {
		return answerOrder;
	}

	public void setAnswerOrder(String answerOrder) {
		this.answerOrder = answerOrder;
	}

	public Long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
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

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
	
	
}
