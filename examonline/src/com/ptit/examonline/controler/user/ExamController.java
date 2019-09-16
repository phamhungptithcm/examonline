package com.ptit.examonline.controler.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ptit.examonline.helper.HelperController;

@Controller
@RequestMapping("exam")
public class ExamController extends HelperController {
	
	@GetMapping("to-do")
	public String getExamToDo() {
		System.out.println("Connected to exam/to-do.html");
		return viewUserPages("exam/todoexam.jsp");
	}
	@PostMapping("to-do")
	public String getExamToDo(Model model, @RequestParam("level") String level) {
		System.out.println("Connected to exam/to-do.html");
		System.out.println(level);
		return viewUserPages("exam/todoexam.jsp");
	}
	@GetMapping("result")
	public String getResult(Model model) {
		System.out.println("Connected to exam/result.html");
		return viewUserPages("exam/result.jsp");
	}
}
