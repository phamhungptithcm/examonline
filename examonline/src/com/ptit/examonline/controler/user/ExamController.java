package com.ptit.examonline.controler.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ptit.examonline.dto.ResultOverviewDTO;
import com.ptit.examonline.entity.Question;
import com.ptit.examonline.helper.HelperConst;
import com.ptit.examonline.helper.HelperController;
import com.ptit.examonline.service.ExamService;
import com.ptit.examonline.service.QuestionService;
import com.ptit.examonline.service.ResultService;

@Controller
@RequestMapping("exam")
public class ExamController extends HelperController {
	@Autowired
	private ExamService examService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	ResultService resultService;
	
	@GetMapping("to-do")
	public String getExamToDo() {
		return viewUserPages("exam/todoexam.jsp");
	}
	
	@PostMapping("to-do")
	public String getExamToDo(Model model, @RequestParam("subject") Integer level) {
		try {
			List<Question> questions = questionService.getExam(level);
			if(questions.size() > 0 && questions != null) {
				model.addAttribute("subject", HelperConst.getSubject(level));
				model.addAttribute("questions", questions);
				
				resultService.addResult(questions);
			} else {
				model.addAttribute("status",false);
				return "redirect:../home/index.htm";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return viewUserPages("exam/todoexam.jsp");
	}
	@GetMapping("submit-quiz")
	public String submitQuiz(Model model) {
		ResultOverviewDTO dto = null;
		try {
			dto = examService.submitQuiz(resultService.getResult());
			model.addAttribute("quizResultDTO",dto);
			resultService.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewUserPages("exam/result.jsp");
	}
	
	@ResponseBody
	@RequestMapping("update-result")
	public String update(
			@RequestParam("questionId") Long questionId, 
			@RequestParam("answerId") Long answerId) {
		resultService.updateResult(questionId, answerId);
		return String.format("{\"questionId\":%d, \"answerId\":%d}",questionId, answerId);
	}
}
