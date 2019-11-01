package com.ptit.examonline.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.ptit.examonline.dto.QuizDTO;
import com.ptit.examonline.entity.Anwser;
import com.ptit.examonline.entity.Question;

@Service
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ResultService {
	
	HashMap<Long, QuizDTO> results = new HashMap<>();
	private Date curDate = new Date();
	public void addResult(List<Question> questions) {
		QuizDTO result = null;
		for (Question question : questions) {
			if(results.get(question.getQuestionId()) == null) {
				result = new QuizDTO();
				List<Long> answerOrder = new ArrayList<>();
				for (Anwser anwser : question.getAnwsers()) {
					answerOrder.add(anwser.getAnwserId());
				}
				result.setAnswerId(null);
				result.setQuestionId(question.getQuestionId());
				result.setAnswerOrder(answerOrder);
				result.setStartTime(new Timestamp(curDate.getTime()));
				results.put(question.getQuestionId(), result);
			}
		}
	}
	public Collection<QuizDTO> getResult() {
		return results.values();
	}
	public void clear() {
		results.clear();
	}
	public void updateResult(Long questionId, Long answerId) {
		QuizDTO dto = results.get(questionId);
		dto.setAnswerId(answerId);
	}
}
