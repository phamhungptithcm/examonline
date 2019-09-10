package com.ptit.examonline.controler.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ptit.examonline.dto.AccountMessage;
import com.ptit.examonline.dto.LoginInfoDTO;
import com.ptit.examonline.dto.NewAccountInfoDTO;
import com.ptit.examonline.helper.HelperController;
import com.ptit.examonline.service.AccountService;

@Controller
@RequestMapping("account")
public class AccountController extends HelperController{
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("signin")
	public String signin(Model model) {
		System.out.println("Connected to account/signin.html <GET>");
		LoginInfoDTO loginInfoDTO = new LoginInfoDTO();
		model.addAttribute("loginInfoDTO", loginInfoDTO);
		return viewUserPages("../common/signinorsignup.jsp");
	}
	
	@PostMapping("signin")
	public String signin(Model model,@ModelAttribute("loginInfoDTO") LoginInfoDTO loginInfoDTO) {
		System.out.println("Connected to account/signin.html <POST>");
		AccountMessage message = null;
		try {
			 message = accountService.signin(session, loginInfoDTO);
			if(message.getStatus() == true) {
				if(loginInfoDTO.getRemember() == true) {
					this.addCookie("uid", loginInfoDTO.getUserName(), 30);
					this.addCookie("pwd", loginInfoDTO.getPassword(), 30);
				}
				else {
					this.removeCookie("uid");
					this.removeCookie("pwd");
				}
				return "redirect:../home/index.htm";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("message", message);
		return viewUserPages("../common/signinorsignup.jsp");
	}
	
	@GetMapping("signup")
	public String signup(Model model) {
		System.out.println("Connected to account/signup.html <GET>");
		
		model.addAttribute("loginInfoDTO", new NewAccountInfoDTO());
		return viewUserPages("../common/signinorsignup.jsp");
	}
	
	@PostMapping("signup")
	public String signup(Model model,@ModelAttribute("account") NewAccountInfoDTO account) {
		System.out.println("Connected to account/signin.html <POST>");
		AccountMessage message = null;
		try {
			message = accountService.signup(account);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewUserPages("../common/signinorsignup.jsp");
	}
	
	@GetMapping("signout")
	public String signout() {
		session.removeAttribute("user");
		return "redirect:signin.htm";
	}
	
	@GetMapping("account-overview")
	public String accountOverview(Model model) {
		System.out.println("Connected to account/account-overview.html <GET>");
		
		model.addAttribute("btnTitle", "Acount Overview");
		return viewUserPages("account/overview.jsp");
	}
	
	@GetMapping("manage-appointment")
	public String manageAppointment() {
		System.out.println("Connected to account/manage-appointment.html <GET>");
		return viewUserPages("account/appointment.jsp");
	}
	
	@GetMapping("edit-account")
	public String editAccount(Model model) {
		System.out.println("Connected to account/edit-account.html <GET>");
		
		model.addAttribute("btnTitle", "Edit Account Information");
		return viewUserPages("account/edit-accountinfor.jsp");
	}
	@GetMapping("test-result")
	public String getTestRessult() {
		System.out.println("Connected to account/test-result.html <GET>");
		return viewUserPages("account/test-result.jsp");
	}
}
