package com.ptit.examonline.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ptit.examonline.helper.HelperController;

@Controller
@RequestMapping("admin/person")
public class PersonController extends HelperController{

	
	@RequestMapping("index")
	public String index(Model model) {
		return viewAdminPages("person/index.htm");
	}
}
