package com.ptit.examonline.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.examonline.dto.ExamDTO;
import com.ptit.examonline.dto.QuizDTO;
import com.ptit.examonline.dto.ResultOverviewDTO;
import com.ptit.examonline.entity.Exam;

@Transactional
@Service
public interface ExamService {
	public ResultOverviewDTO submitQuiz(Collection<QuizDTO> quizDTOs) throws Exception;

	public List<ExamDTO> getExams() throws Exception;

	public ResultOverviewDTO getResults(Long examId) throws Exception;
	public List<Exam> getExamss() throws Exception;

	public QuizDTO getExamByExamId(Long examId) throws Exception;

	public boolean updateExam(Long examId, Double score);

	public List<Exam> getExamss(int pageNo, int pageSize);
}
