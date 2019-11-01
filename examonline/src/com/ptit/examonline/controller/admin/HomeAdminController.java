package com.ptit.examonline.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ptit.examonline.helper.HelperController;

@Controller
@RequestMapping("admin/home")
public class HomeAdminController extends HelperController{
	
	@RequestMapping("index")
	public String index() {
		return viewAdminPages("home/index.jsp");
	}
}
