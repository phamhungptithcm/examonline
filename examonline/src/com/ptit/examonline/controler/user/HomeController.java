package com.ptit.examonline.controler.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ptit.examonline.helper.HelperConst;
import com.ptit.examonline.helper.HelperController;

@Controller
@RequestMapping("home")
public class HomeController extends HelperController{
	
	
	@GetMapping("index.htm")
	public String index(Model model) {
		model.addAttribute("subjects",HelperConst.getSubjects());
		return viewUserPages("home/index.jsp");
	}
}
