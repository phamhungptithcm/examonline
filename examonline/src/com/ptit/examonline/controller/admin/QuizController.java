package com.ptit.examonline.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ptit.examonline.helper.HelperController;
import com.ptit.examonline.service.ExamService;

@Controller
@RequestMapping("admin/quiz")
public class QuizController extends HelperController{
	@Autowired
	private ExamService examService;
	
	
	@RequestMapping("index")
	public String index(Model model) {
		try {
			model.addAttribute("exams", examService.getExamss());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewAdminPages("quiz/index.jsp");
	}
}
