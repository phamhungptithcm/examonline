package com.ptit.examonline.dto;

import java.util.List;

public class ResultOverviewDTO {
	private List<ResultQuizDTO> resultQuizDTOs;
	private Double score;
	private int time;
	
	
	public List<ResultQuizDTO> getResultQuizDTOs() {
		return resultQuizDTOs;
	}
	public void setResultQuizDTOs(List<ResultQuizDTO> resultQuizDTOs) {
		this.resultQuizDTOs = resultQuizDTOs;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	
}
