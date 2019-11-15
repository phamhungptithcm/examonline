package com.ptit.examonline.service.imp;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ptit.examonline.dao.AnwserDAO;
import com.ptit.examonline.dao.QuestionDAO;
import com.ptit.examonline.entity.Account;
import com.ptit.examonline.entity.Anwser;
import com.ptit.examonline.entity.Question;
import com.ptit.examonline.helper.HelperService;
import com.ptit.examonline.service.QuestionService;

@Component
public class QuestionServiceImp extends HelperService implements QuestionService {

	@Autowired
	private QuestionDAO questionDAO;
	
	@Autowired
	private AnwserDAO anwserDAO;
	
	private static Date date = new Date();
	private static Timestamp timestamp = new Timestamp(date.getTime());

	@Override
	public List<Question> getExam(Integer level) throws Exception {
		List<Question> questions = questionDAO.getQuestionsRandom(level);
		return questions;
	}

	@Override
	public List<Question> getQuestions(int pageNo, int pageSize) throws Exception {
		return questionDAO.getQuestions(pageNo, pageSize);
	}

	@Override
	public Question getQuestion(Long questionId) throws Exception {
		return questionDAO.getQuestionByQuestionId(questionId);
	}

	@Override
	public boolean updateQuestion(Question question) throws Exception {
		Account account = getCurrentAccount();
		Question oldQuestion = questionDAO.getQuestionByQuestionId(question.getQuestionId());
		boolean result = false;
		if(oldQuestion != null) {
			for (Anwser anwser : question.getAnwsers()) {
				anwser.setModifiedBy(account.getUserName());
				anwser.setDateModified(timestamp);
				anwserDAO.update(anwser);
			}
			oldQuestion.setContent(question.getContent());
			oldQuestion.setLevel(question.getLevel());
			oldQuestion.setDateModified(timestamp);
			oldQuestion.setIsActive(question.getIsActive());
			oldQuestion.setModifiedBy(account.getUserName());
			questionDAO.update(oldQuestion);
			
			result = true;
		}
		return result;
	}

	@Override
	public List<Question> getQuestions() throws Exception {
		return questionDAO.getQuestions();
	}

	@Override
	public boolean saveQuestion(Question question) throws Exception {
		Account account = getCurrentAccount();
		List<Anwser> anwsers= question.getAnwsers();
		question.setAnwsers(null);
		boolean result = false;
		if (question != null) {
			question.setCreatedBy(account.getUserName());
			question.setDateCreated(timestamp);
			question.setDateModified(timestamp);
			question.setModifiedBy(account.getUserName());
			question.setIsActive(true);
			questionDAO.insert(question);
			for (Anwser anwser : anwsers) {
				anwser.setModifiedBy(account.getUserName());
				anwser.setDateModified(timestamp);
				anwser.setDateCreated(timestamp);
				anwser.setCreatedBy(account.getUserName());
				anwser.setQuestion(question);
				anwserDAO.insert(anwser);
			}
			result = true;
		}
		return result;
	}

	@Override
	public boolean deleteQuestion(Long questionId) {
		Question question = questionDAO.getQuestionByQuestionId(questionId);
		if (question != null) {
			for (Anwser anwser : question.getAnwsers()) {
				anwserDAO.delete(anwser);
			}
			questionDAO.delete(question);
			return true;
		}
		return false;
	}

}
