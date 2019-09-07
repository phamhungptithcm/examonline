package com.ptit.examonline.controler.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ptit.examonline.helper.HelperController;

@Controller
@RequestMapping("exam")
public class ExamController extends HelperController{
	
	@GetMapping("to-do")
	public String getExamToDo(Model model) {
		System.out.println("Connected to exam/to-do.html");
		return viewUserPages("exam/todoexam.jsp");
	}
	
	@GetMapping("result")
	public String getResult(Model model) {
		System.out.println("Connected to exam/result.html");
		return viewUserPages("exam/result.jsp");
	}
}
