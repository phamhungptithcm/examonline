package com.ptit.examonline.controler.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ptit.examonline.helper.HelperController;

@Controller
@RequestMapping("home")
public class HomeController extends HelperController{
	
	@GetMapping("index.htm")
	public String index(Model model) {
		System.out.println("Connected to home/index.html");
		return viewUserPages("home/index.jsp");
	}
}
