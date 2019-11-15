package com.ptit.examonline.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ptit.examonline.dto.QuizDTO;
import com.ptit.examonline.helper.HelperController;
import com.ptit.examonline.service.ExamService;

@Controller
@RequestMapping("admin/quiz")
public class QuizController extends HelperController{
	@Autowired
	private ExamService examService;
	
	
	@RequestMapping("index")
	public String index(Model model) {
		return viewAdminPages("quiz/index.jsp");
	}
	@RequestMapping("get-page")
	public String getPage(Model model, @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
		try {
			model.addAttribute("exams", examService.getExamss(pageNo, pageSize));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/quiz/list";
	}
	
	@ResponseBody
	@RequestMapping("get-page-count")
	public String getPageCount(Model model, @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
		int pageCount = 0;
		try {
			int rowCount = examService.getExamss().size();
			pageCount = (int) Math.ceil(1.0 * rowCount / pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return String.valueOf(pageCount);
	}
	@ResponseBody
	@GetMapping("update")
	public String update(@RequestParam("examId") Long examId) {
		
		ObjectMapper mapper = new ObjectMapper();
		String result = "";
		try {
			QuizDTO quizDTO  = examService.getExamByExamId(examId);
			 result = mapper.writeValueAsString(quizDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@PostMapping("update")
	public String update(Model model,@RequestParam("examId") Long examId, 
			@RequestParam("score") Double score, @RequestParam("comment") String comment) {
		try {
			model.addAttribute("status", examService.updateExam(examId,score)); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect: index.htm";
	}
	
	@GetMapping(value = "detail")
	public String getTestRessult(Model model, @RequestParam("id") Long examId) {
		try {
			model.addAttribute("resultDTO", examService.getResults(examId));	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewAdminPages("quiz/result.jsp");
	}
}
