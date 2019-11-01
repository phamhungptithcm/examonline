package com.ptit.examonline.dto;

import java.sql.Timestamp;
import java.util.List;

public class QuestionDTO {
	private Long questionId;
	private String content;
	private Long answerId;
	private Integer level;
	private Boolean isCorrect;
	private List<AnswerDTO> answerDTOs;
	private String sAnswerOrder;
	private Timestamp startTime;
	
	
	public QuestionDTO() {
		super();
	}
	public List<AnswerDTO> getAnswerDTOs() {
		return answerDTOs;
	}
	public void setAnswerDTOs(List<AnswerDTO> answerDTOs) {
		this.answerDTOs = answerDTOs;
	}
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
	public Long getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}
	
	public String getsAnswerOrder() {
		return sAnswerOrder;
	}
	public void setsAnswerOrder(String sAnswerOrder) {
		this.sAnswerOrder = sAnswerOrder;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Boolean getIsCorrect() {
		return isCorrect;
	}
	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	
}
