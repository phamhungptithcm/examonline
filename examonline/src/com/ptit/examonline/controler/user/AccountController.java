package com.ptit.examonline.controler.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ptit.examonline.dto.AccountMessage;
import com.ptit.examonline.dto.LoginInfoDTO;
import com.ptit.examonline.dto.NewAccountInfoDTO;
import com.ptit.examonline.dto.PersonInfoDTO;
import com.ptit.examonline.helper.HelperController;
import com.ptit.examonline.service.AccountService;
import com.ptit.examonline.service.PersonService;

@Controller
@RequestMapping("account")
public class AccountController extends HelperController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private PersonService personService;

	@GetMapping(value = "account-log")
	public String signin(Model model) {
		System.out.println("Connected to account/signin.html <GET>");
		
		model.addAttribute("signin", new LoginInfoDTO());
		model.addAttribute("signup",  new NewAccountInfoDTO());
		return viewUserPages("../common/signinorsignup.jsp");
	}

	@PostMapping(value = "account-log")
	public String signin(Model model,@ModelAttribute("signin") LoginInfoDTO loginInfoDTO) {
		System.out.println("Connected to account/signin.html <signin>");
		AccountMessage message = null;
		try {
			message = accountService.signin(loginInfoDTO);
			if (message.getStatus() == true) {
				if (loginInfoDTO.getRemember() == true) {
					this.addCookie("uid", loginInfoDTO.getUserName(), 30);
					this.addCookie("pwd", loginInfoDTO.getPassword(), 30);
				} else {
					this.removeCookie("uid");
					this.removeCookie("pwd");
				}
				return "redirect:../home/index.htm";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		model.addAttribute("message", message);
		return viewUserPages("../common/signinorsignup.jsp");
	}
	
	@PostMapping(value = "account-log", params = "signup")
	public String signup(Model model,@ModelAttribute("signup") NewAccountInfoDTO newAccountInfoDTO) {
		System.out.println("Connected to account/signin.html <POST>");
		AccountMessage message = null;
		try {
			message = accountService.signup(newAccountInfoDTO);
			if (message.getStatus()) {
				LoginInfoDTO loginInfoDTO = new LoginInfoDTO();
				loginInfoDTO.setUserName(newAccountInfoDTO.getUserName());
				loginInfoDTO.setPassword(newAccountInfoDTO.getPassword());
				loginInfoDTO.setRemember(false);
				message = accountService.signin(loginInfoDTO);
				if (message.getStatus() == true) {
					if (loginInfoDTO.getRemember() == true) {
						this.addCookie("uid", loginInfoDTO.getUserName(), 30);
						this.addCookie("pwd", loginInfoDTO.getPassword(), 30);
					} else {
						this.removeCookie("uid");
						this.removeCookie("pwd");
					}
					return "redirect:../home/index.htm";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return viewUserPages("../common/signinorsignup.jsp");
	}

	@GetMapping(value = "account-log", params = "signout")
	public String signout() {
		session.removeAttribute("user");
		return "redirect:account-log.htm";
	}
	@PostMapping(value = "account-log", params = "fogot")
	public String fogot(Model model, @RequestParam("email") String email) {
		AccountMessage message = null;
		try {
			message = accountService.fogotPassword(email);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		model.addAttribute("message", message);
		return viewUserPages("../common/signinorsignup.jsp");
	}
	
	@GetMapping(value = "account-log", params = "reset")
	public String reset() {
		return viewUserPages("../common/signinorsignup.jsp");
	}
	@PostMapping(value = "account-log", params = "reset")
	public String reset(Model model, @RequestParam("password") String password, @RequestParam("email") String email) {
		AccountMessage message = null;
		try {
			message = accountService.resetPassword(password, email);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		model.addAttribute("message", message);
		return viewUserPages("account/reset.jsp");
	}

	@GetMapping(value = "account-management")
	public String accountOverview(Model model) {
		System.out.println("Connected to account/account-overview.html <GET>");
		
		model.addAttribute("btnTitle", "Acount Overview");
		return viewUserPages("account/overview.jsp");
	}

	@GetMapping(value = "account-management", params = "appointment")
	public String manageAppointment() {
		System.out.println("Connected to account/manage-appointment.html <GET>");
		return viewUserPages("account/appointment.jsp");
	}

	@GetMapping(value = "account-management", params = "editaccount")
	public String editAccount(Model model) {
		System.out.println("Connected to account/edit-account.html <GET>");
		model.addAttribute("personInfo", new PersonInfoDTO());
		model.addAttribute("btnTitle", "Edit Account Information");
		return viewUserPages("account/edit-accountinfor.jsp");
	}
	@PostMapping(value="account-management", params="changepassword")
	public String changePassword(Model model,
			@RequestParam("username") String userName,
			@RequestParam("password") String password) {
		System.out.println("Connected to account/changepassword.html <POST>");
		AccountMessage message = null;
		try {
			message = accountService.changePassword(userName, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		model.addAttribute("message", message);
		
		return viewUserPages("account/edit-accountinfor.jsp");
	}
	@PostMapping(value="account-management", params="updateinfo")
	public String updatePersonInfo(Model model,@ModelAttribute("personInfo") PersonInfoDTO infoDTO) {
		try {
			AccountMessage message = personService.updatePersonInfo(infoDTO);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return viewUserPages("account/edit-accountinfor.jsp");
	}
	@GetMapping(value = "account-management", params = "testresult")
	public String getTestRessult() {
		System.out.println("Connected to account/test-result.html <GET>");
		return viewUserPages("account/test-result.jsp");
	}
}
