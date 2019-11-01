package com.ptit.examonline.dto;

public class ResultQuizDTO {
	private QuestionDTO question;
	private Long answerId;
	private String answerOrder;
	private boolean isIgnore;
	private boolean status;
	
	public QuestionDTO getQuestion() {
		return question;
	}
	public void setQuestion(QuestionDTO question) {
		this.question = question;
	}
	public Long getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}
	public boolean getIgnore() {
		if(this.answerId == null) {
			this.isIgnore = true;
		} else {
			this.isIgnore = false;
		}
		return isIgnore;
	}
	public String getAnswerOrder() {
		return answerOrder;
	}
	public void setAnswerOrder(String answerOrder) {
		this.answerOrder = answerOrder;
	}
	public final boolean getStatus() {
		this.status = false;
		for (AnswerDTO anwser : question.getAnswerDTOs()) {
			if(anwser.getAnswerId().equals(this.answerId)) {
				this.status = true;
				break;
			}
		}
		return this.status;
	}
	
}
