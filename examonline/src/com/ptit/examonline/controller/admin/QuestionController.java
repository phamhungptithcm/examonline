package com.ptit.examonline.controller.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ptit.examonline.entity.Anwser;
import com.ptit.examonline.entity.Question;
import com.ptit.examonline.helper.HelperConst;
import com.ptit.examonline.helper.HelperController;
import com.ptit.examonline.service.QuestionService;
import com.ptit.examonline.validation.QuestionValidation;

@Controller
@RequestMapping("admin/question")
public class QuestionController extends HelperController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	QuestionValidation questionValidation;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(questionValidation);
	}

	@RequestMapping("index")
	public String index() {
		return viewAdminPages("question/index.jsp");
	}
	@RequestMapping("get-page")
	public String getPage(Model model, @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		System.out.println(pageNo + "-" + pageSize);
		try {
			model.addAttribute("questions", questionService.getQuestions(pageNo, pageSize));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/question/list";
	}
	@RequestMapping("edit")
	public String edit(Model model, @RequestParam("id") Long questionId) {
		try {
			model.addAttribute("question", questionService.getQuestion(questionId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewAdminPages("question/update.jsp");
	}

	@PostMapping("edit")
	public String edit(Model model, @ModelAttribute @Validated Question question, BindingResult result) {
		try {
			if(result.hasErrors())  {
				return viewAdminPages("question/update.jsp");
			}
			model.addAttribute("status", questionService.updateQuestion(question));
		} catch (Exception e) {
			e.printStackTrace();
			return viewAdminPages("question/update.jsp");
		}
		return "redirect: index.htm";
	}

	@ResponseBody
	@RequestMapping("get-page-count")
	public String getPageCount(Model model, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		int pageCount = 0;
		try {
			int rowCount = questionService.getQuestions().size();
			pageCount = (int) Math.ceil(1.0 * rowCount / pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return String.valueOf(pageCount);
	}
	
	@ResponseBody
	@RequestMapping("delete")
	public String delete(@RequestParam("id") Long questionId) {
		Long result = 0L;
		try {
			boolean isTrue = questionService.deleteQuestion(questionId);
			if(isTrue) {
				result = questionId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(result);
	}
	
	@ModelAttribute("s	ubjects") 
	public Map<Integer, String> getSubjects() {
		return HelperConst.getSubjects();
	}
	@RequestMapping("insert")
	public String insert(Model model) {
		
		model.addAttribute("question",createNewQuestion());
		return viewAdminPages("question/insert.jsp");
	}
	private Question createNewQuestion() {
		List<Anwser> anwsers = new ArrayList<Anwser>();
		for (int i = 0; i < 4; i++) {
			Anwser anwser = new Anwser();
			anwsers.add(anwser);
		}
		Question question = new Question();
		question.setAnwsers(anwsers);
		return question;
	}
	
	@PostMapping("insert")
	public String insert(Model model, @ModelAttribute @Validated Question question, BindingResult result) {
		try {
			if(result.hasErrors())  {
				return viewAdminPages("question/update.jsp");
			}
			model.addAttribute("status", questionService.saveQuestion(question));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect: index.htm";
	}
}
