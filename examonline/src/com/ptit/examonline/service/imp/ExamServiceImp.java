package com.ptit.examonline.service.imp;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ptit.examonline.dao.ExamDAO;
import com.ptit.examonline.dao.QuestionDAO;
import com.ptit.examonline.dao.QuestionResultDAO;
import com.ptit.examonline.dto.AnswerDTO;
import com.ptit.examonline.dto.ExamDTO;
import com.ptit.examonline.dto.ExamDetailDTO;
import com.ptit.examonline.dto.QuestionDTO;
import com.ptit.examonline.dto.QuizDTO;
import com.ptit.examonline.dto.ResultOverviewDTO;
import com.ptit.examonline.dto.ResultQuizDTO;
import com.ptit.examonline.entity.Account;
import com.ptit.examonline.entity.Anwser;
import com.ptit.examonline.entity.Exam;
import com.ptit.examonline.entity.Question;
import com.ptit.examonline.entity.QuestionResult;
import com.ptit.examonline.helper.HelperConst;
import com.ptit.examonline.helper.HelperService;
import com.ptit.examonline.service.ExamService;

@Component
public class ExamServiceImp extends HelperService implements ExamService {
	private static final String FORMATDATE_COMPARE = "MM/dd/yyyy";
	private static final String FORMATDATE_DISPLAY = "dd MMM";
	private static final String FORMATIME_DISPLAY = "HH:mm a";
	@Autowired
	private ExamDAO examDAO;

	@Autowired
	private QuestionDAO questionDAO;

	@Autowired
	private QuestionResultDAO questionResultDAO;

	private Date curDate = new Date();

	@Override
	public ResultOverviewDTO submitQuiz(Collection<QuizDTO> quizDTOs) throws Exception {
		Account curUser = getCurrentAccount();
		ResultOverviewDTO dto = caculateResultQuiz(quizDTOs);
		Exam exam = new Exam();
		exam.setCreatedBy(curUser.getUserName());
		exam.setModifiedBy(curUser.getUserName());
		exam.setAccount(curUser);
		exam.setDateCreated(new Timestamp(curDate.getTime()));
		exam.setDateModified(new Timestamp(curDate.getTime()));
		exam.setScore(dto.getScore());
		examDAO.insert(exam);
		for (ResultQuizDTO data : dto.getResultQuizDTOs()) {
			QuestionResult result = new QuestionResult();
			result.setAnswerId(data.getAnswerId());
			result.setAnswerOrder(data.getAnswerOrder());
			result.setCreatedBy(curUser.getUserName());
			result.setModifiedBy(curUser.getUserName());
			result.setDateCreated(new Timestamp(curDate.getTime()));
			result.setDateModified(new Timestamp(curDate.getTime()));
			result.setExam(exam);
			result.setQuestionId(data.getQuestion().getQuestionId());

			questionResultDAO.insert(result);
		}
		System.out.println(dto.getResultQuizDTOs().size());
		return dto;
	}

	private ResultOverviewDTO caculateResultQuiz(Collection<QuizDTO> quizDTOs) {
		Double score = 0.0;
		Timestamp start = null;

		ResultOverviewDTO dto = new ResultOverviewDTO();
		List<ResultQuizDTO> resultQuizDTOs = new ArrayList<>();
		for (QuestionDTO questionDTO : getListQuestions(quizDTOs)) {
			start = questionDTO.getStartTime();
			ResultQuizDTO resultQuizDTO = new ResultQuizDTO();
			resultQuizDTO.setQuestion(questionDTO);
			resultQuizDTO.setAnswerId(questionDTO.getAnswerId());
			questionDTO.setIsCorrect(false);
			resultQuizDTO.setAnswerOrder(questionDTO.getsAnswerOrder());
			for (AnswerDTO answerDTO : questionDTO.getAnswerDTOs()) {
				if (answerDTO != null && questionDTO.getAnswerId() != null) {
					if (questionDTO.getAnswerId().equals(answerDTO.getAnswerId())
							&& answerDTO.getStatus().equals(true)) {
						questionDTO.setIsCorrect(true);
						score += 1.0;
						break;
					}
				}

			}
			resultQuizDTOs.add(resultQuizDTO);
		}
		dto.setResultQuizDTOs(resultQuizDTOs);
		dto.setScore(score);
		Timestamp end = new Timestamp(curDate.getTime());
		dto.setTime(caculateTime(start, end));
		return dto;
	}

	private List<QuestionDTO> getListQuestions(Collection<QuizDTO> quizDTOs) {
		List<Question> questions = questionDAO.getQuestions();
		List<QuestionDTO> questionDTOs = new ArrayList<>();
		for (Question question : questions) {
			for (QuizDTO quizDTO : quizDTOs) {
				if (question.getQuestionId().equals(quizDTO.getQuestionId())) {
					List<AnswerDTO> answerDTOs = new ArrayList<>();
					for (Anwser anwser : question.getAnwsers()) {
						AnswerDTO answerDTO = new AnswerDTO();
						answerDTO.setAnswerId(anwser.getAnwserId());
						answerDTO.setContent(anwser.getContent());
						answerDTO.setStatus(anwser.getStatus());

						answerDTOs.add(answerDTO);
					}
					QuestionDTO questionDTO = new QuestionDTO();
					questionDTO.setAnswerDTOs(answerDTOs);
					questionDTO.setContent(question.getContent());

					questionDTO.setQuestionId(question.getQuestionId());
					questionDTO.setAnswerId(quizDTO.getAnswerId());
					questionDTO.setsAnswerOrder(Arrays.toString(quizDTO.getAnswerOrder().toArray()));
					questionDTO.setStartTime(quizDTO.getStartTime());
					questionDTOs.add(questionDTO);
				}

			}

		}
		return questionDTOs;
	}

	private int caculateTime(Timestamp start, Timestamp end) {
		long milliseconds = start.getTime() - end.getTime();
		int seconds = (int) milliseconds / 1000;
		return seconds;
	}

	@Override
	public List<ExamDTO> getExams() throws Exception {
		List<Exam> exams = examDAO.getExams();
		List<ExamDTO> examDTOs = new ArrayList<>();
		Collections.sort(exams, new Comparator<Exam>() {
			@Override
			public int compare(Exam exam1, Exam exam2) {
				return exam2.getDateCreated().compareTo(exam1.getDateCreated());
			}
		});

		for (Exam exam : exams) {
			Date date = new Date(exam.getDateCreated().getTime());
			ExamDTO examDTO = new ExamDTO();
			examDTO.setQuizDate(exam.getDateCreated());

			examDTO.setStrStartDate(convertDateToStirng(date, FORMATDATE_COMPARE));
			examDTOs.add(examDTO);
		}
		return this.addListExamDetail(examDTOs, exams);
	}

	private String convertDateToStirng(Date date, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String strDate = formatter.format(date);

		return strDate;
	}

	private List<ExamDTO> addListExamDetail(List<ExamDTO> examDTOs, List<Exam> exams) {
		for (ExamDTO examDTO : examDTOs) {
			List<ExamDetailDTO> examDetails = new ArrayList<>();
			Integer subjectId = null;
			for (Exam exam : exams) {
				if (exam.getQuestionResults() != null && exam.getQuestionResults().size() > 0) {
					Long questionId = exam.getQuestionResults().get(0).getQuestionId();
					Question question = questionDAO.getQuestionByQuestionId(questionId);
					subjectId = question.getLevel();
				}
				Date date = new Date(exam.getDateCreated().getTime());
				String sDate = convertDateToStirng(date, FORMATDATE_COMPARE);
				if (examDTO.getStrStartDate().equals(sDate)) {
					ExamDetailDTO examDetail = new ExamDetailDTO();
					examDetail.setExamId(exam.getExamId());
					examDetail.setExamName("Made the " + HelperConst.getSubject(subjectId) + " quiz");
					examDetail.setScore(exam.getScore());
					examDetail.setStartTime(convertDateToStirng(date, FORMATIME_DISPLAY));
					examDetails.add(examDetail);
				}
			}
			Date date = new Date(examDTO.getQuizDate().getTime());
			examDTO.setExamDetails(examDetails);
			examDTO.setStrStartDate(convertDateToStirng(date, FORMATDATE_DISPLAY));
			examDTO.setStartDate(date);
		}
		for (int i = 0; i < examDTOs.size(); i++) {
			for (int j = 0; j < examDTOs.size() - 1; j++) {
				if (convertDateToStirng(examDTOs.get(i).getStartDate(), FORMATDATE_COMPARE)
						.equals(convertDateToStirng(examDTOs.get(j).getStartDate(), FORMATDATE_COMPARE))) {
					examDTOs.remove(j);
				}
			}
		}
		return examDTOs;
	}

	@Override
	public ResultOverviewDTO getResults(Long examId) throws Exception {
		Exam exam = examDAO.getExamsByExamId(examId);
		ResultOverviewDTO overviewDTO = new ResultOverviewDTO();
		if (exam != null) {
			List<ResultQuizDTO> resultQuizDTOs = new ArrayList<>();
			for (QuestionResult questionResult : exam.getQuestionResults()) {
				ResultQuizDTO resultQuizDTO = new ResultQuizDTO();
				resultQuizDTO.setAnswerId(questionResult.getAnswerId());
				resultQuizDTO.setQuestion(
						this.getQuestionDTOs(questionResult.getQuestionId(), questionResult.getAnswerId()));
				resultQuizDTO.setAnswerOrder(questionResult.getAnswerOrder());
				resultQuizDTOs.add(resultQuizDTO);
			}
			overviewDTO.setResultQuizDTOs(resultQuizDTOs);
			overviewDTO.setScore(exam.getScore());
			overviewDTO.setTime(13);

		}
		return overviewDTO;
	}

	private QuestionDTO getQuestionDTOs(Long questionId, Long answerId) {
		QuestionDTO questionDTO = new QuestionDTO();
		Question question = questionDAO.getQuestionByQuestionId(questionId);

		List<AnswerDTO> answerDTOs = new ArrayList<>();
		Boolean isCorrect = false;
		for (Anwser anwser : question.getAnwsers()) {
			AnswerDTO answerDTO = new AnswerDTO();
			answerDTO.setAnswerId(anwser.getAnwserId());
			answerDTO.setContent(anwser.getContent());
			answerDTO.setStatus(anwser.getStatus());
			answerDTOs.add(answerDTO);
			if (answerId != null && anwser != null && answerId.equals(anwser.getAnwserId()) && anwser.getStatus().equals(true)) {
				isCorrect = true;
			}
		}
		questionDTO.setAnswerId(answerId);
		questionDTO.setLevel(question.getLevel());
		questionDTO.setQuestionId(question.getQuestionId());
		questionDTO.setContent(question.getContent());
		questionDTO.setIsCorrect(isCorrect);
		questionDTO.setAnswerDTOs(answerDTOs);
		return questionDTO;
	}

	@Override
	public List<Exam> getExamss() throws Exception {
		return examDAO.getExams();
	}

	@Override
	public QuizDTO getExamByExamId(Long examId) throws Exception {
		Exam exam = examDAO.getExamsByExamId(examId);
		QuizDTO dto = null;
		if (exam != null) {
			dto = new QuizDTO();
			dto.setExamId(examId);
			dto.setScore(exam.getScore());
		}

		return dto;
	}

	@Override
	public boolean updateExam(Long examId, Double score) {
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		boolean result = false;
		try {
			Exam exam = examDAO.getExamsByExamId(examId);
			if (exam != null) {
				exam.setScore(score);
				exam.setModifiedBy(getCurrentAccount().getUserName());
				exam.setDateModified(timestamp);
				examDAO.update(exam);
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Exam> getExamss(int pageNo, int pageSize) {
		return examDAO.getExams(pageNo,pageSize);
	}
}
