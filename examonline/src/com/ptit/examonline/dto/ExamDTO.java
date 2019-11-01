package com.ptit.examonline.dto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class ExamDTO {
	private Timestamp quizDate;
	private String strStartDate;
	private Date startDate;
	private List<ExamDetailDTO> examDetails;
	
	public Timestamp getQuizDate() {
		return quizDate;
	}
	public void setQuizDate(Timestamp quizDate) {
		this.quizDate = quizDate;
	}
	
	public String getStrStartDate() {
		return strStartDate;
	}
	public void setStrStartDate(String strStartDate) {
		this.strStartDate = strStartDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public List<ExamDetailDTO> getExamDetails() {
		return examDetails;
	}
	public void setExamDetails(List<ExamDetailDTO> examDetails) {
		this.examDetails = examDetails;
	}
	
	
}
