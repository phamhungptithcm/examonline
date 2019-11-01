package com.ptit.examonline.dto;

public class AnswerDTO {
	private Long answerId;
	private String content;
	private Boolean status;
	public AnswerDTO(Long answerId, String content, boolean status) {
		super();
		this.answerId = answerId;
		this.content = content;
		this.status = status;
	}
	public AnswerDTO() {
		super();
	}
	public Long getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
