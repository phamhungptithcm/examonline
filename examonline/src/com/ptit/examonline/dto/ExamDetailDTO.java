package com.ptit.examonline.dto;

import java.sql.Timestamp;

public class ExamDetailDTO {
	private Long examId;
	private Timestamp quizDate;
	private String startTime;
	private String examName;
	private Double score;
	public Timestamp getQuizDate() {
		return quizDate;
	}
	public void setQuizDate(Timestamp quizDate) {
		this.quizDate = quizDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	
	public Long getExamId() {
		return examId;
	}
	public void setExamId(Long examId) {
		this.examId = examId;
	}
}
