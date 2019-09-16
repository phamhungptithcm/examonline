package com.ptit.examonline.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	@Column(name = "QUESTIONID", nullable = false)
	private Long questionId;
	
	@Column(name = "CONTENT", nullable = false)
	private String content;
	
	@Column(name = "LEVEL", nullable = false)
	private Integer level;
	
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
	
	@OneToMany(mappedBy="question")
	Set<Anwser> anwsers;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "QUESTION_EXAM", 
        joinColumns = { @JoinColumn(name = "QUESTIONID") }, 
        inverseJoinColumns = { @JoinColumn(name = "EXAMID") }
    )
    Set<Exam> exams = new HashSet<>();
	
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

	public Set<Anwser> getAnwsers() {
		return anwsers;
	}

	public void setAnwsers(Set<Anwser> anwsers) {
		this.anwsers = anwsers;
	}

	public Set<Exam> getExams() {
		return exams;
	}

	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}
	
}
