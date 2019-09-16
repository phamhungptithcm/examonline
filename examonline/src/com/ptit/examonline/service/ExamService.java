package com.ptit.examonline.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.examonline.entity.Exam;

@Transactional
@Service
public interface ExamService {
	public Exam getExam(Integer level) throws Exception;
}
