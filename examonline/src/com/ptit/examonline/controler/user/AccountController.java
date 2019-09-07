package com.ptit.examonline.controler.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ptit.examonline.dto.LoginInfoDTO;
import com.ptit.examonline.helper.HelperController;
import com.ptit.examonline.service.AccountService;

@Controller
@RequestMapping("account")
public class AccountController extends HelperController{
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("signin")
	public String signin() {
		System.out.println("Connected to account/signin.html <GET>");
		return viewUserPages("../common/signinorsignup.jsp");
	}
	
	@PostMapping("signin")
	public String signin(Model model,@RequestBody LoginInfoDTO user) {
		System.out.println("Connected to account/signin.html <POST>");
		return viewUserPages("../common/signinorsignup.jsp");
	}
	
	@GetMapping("account-overview")
	public String accountOverview() {
		System.out.println("Connected to account/account-overview.html <GET>");
		return viewUserPages("account/overview.jsp");
	}
	
	@GetMapping("manage-appointment")
	public String manageAppointment() {
		System.out.println("Connected to account/manage-appointment.html <GET>");
		return viewUserPages("account/appointment.jsp");
	}
	
	@GetMapping("edit-account")
	public String editAccount() {
		System.out.println("Connected to account/edit-account.html <GET>");
		return viewUserPages("account/edit-accountinfor.jsp");
	}
}
