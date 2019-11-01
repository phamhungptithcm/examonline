package com.ptit.examonline.dto;

import java.sql.Timestamp;
import java.util.List;

public class QuizDTO {
	private Long answerId;
	private Long questionId;
	private List<Long> answerOrder;
	private Timestamp startTime;
	
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
	public List<Long> getAnswerOrder() {
		return answerOrder;
	}
	public void setAnswerOrder(List<Long> answerOrder) {
		this.answerOrder = answerOrder;
	}
	public final Timestamp getStartTime() {
		return startTime;
	}
	public final void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	
	
}
