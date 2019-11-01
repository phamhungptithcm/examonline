package com.ptit.examonline.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.examonline.entity.Question;

@Transactional
@Service
public interface QuestionService {
	
	public List<Question> getExam(Integer level) throws Exception;
}
