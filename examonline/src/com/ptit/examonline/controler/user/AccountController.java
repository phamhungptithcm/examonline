package com.ptit.examonline.controler.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ptit.examonline.dto.AccountDTO;
import com.ptit.examonline.dto.LoginInfoDTO;
import com.ptit.examonline.dto.MessageChecking;
import com.ptit.examonline.helper.HelperController;
import com.ptit.examonline.service.AccountService;
import com.ptit.examonline.service.ResultService;
import com.ptit.examonline.validation.AccountDTOValidation;

@Controller
@RequestMapping("account")
public class AccountController extends HelperController {

	@Autowired
	private AccountService accountService;

	@Autowired
	ResultService resultService;

	@Autowired
	AccountDTOValidation accountDTOValidation;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(accountDTOValidation);
	}

	@GetMapping(value = "account-log")
	public String signin(Model model) {

		model.addAttribute("accountDTO", new AccountDTO());

		return viewUserPages("../common/account-log.jsp");
	}

	@PostMapping(value = "account-log", params = "signin")
	public String signin(Model model, @RequestParam(value = "username") String username,
			@RequestParam("password") String password, @RequestParam("remember") boolean remember,
			@ModelAttribute(value = "accountDTO", binding = false) AccountDTO accountDTO) {
		LoginInfoDTO user = new LoginInfoDTO(username, password, remember);
		MessageChecking message = null;
		try {
			message = accountService.signin(user);
			if (message.getStatus() == true) {
				if (user.getRemember() == true) {
					this.addCookie("uid", user.getUserName(), 30);
					this.addCookie("pwd", user.getPassword(), 30);
				} else {
					this.removeCookie("uid");
					this.removeCookie("pwd");
				}
				if (message.getIsAdmin()) {
					return "redirect:../admin/home/index.htm";
				} else {
					return "redirect:../home/index.htm";
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("message", message);
		return viewUserPages("../common/account-log.jsp");
	}

	@GetMapping(value = "account-log", params = "signup")
	public String signup(Model model) {

		model.addAttribute("accountDTO", new AccountDTO());

		return viewUserPages("../common/account-log.jsp");
	}

	@PostMapping(value = "account-log", params = "signup")
	public String signup(Model model, @ModelAttribute("accountDTO") @Validated  AccountDTO accountDTO, BindingResult result) {
		MessageChecking message = null;
		if(result.hasErrors()) {
			return viewUserPages("../common/account-log.jsp");
		}
		try {
			message = accountService.signup(accountDTO);
			if (message.getStatus()) {
				LoginInfoDTO user = new LoginInfoDTO();
				user.setUserName(accountDTO.getUsername());
				user.setPassword(accountDTO.getPassword());
				user.setRemember(false);
				message = accountService.signin(user);
				if (message.getStatus() == true) {
					if (user.getRemember() == true) {
						this.addCookie("uid", user.getUserName(), 30);
						this.addCookie("pwd", user.getPassword(), 30);
					} else {
						this.removeCookie("uid");
						this.removeCookie("pwd");
					}
					return "redirect:../home/index.htm";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewUserPages("../common/account-log.jsp");
	}

	@GetMapping(value = "account-log", params = "signout")
	public String signout() {
		session.removeAttribute("user");
		return "redirect:account-log.htm";
	}

	@PostMapping(value = "account-log", params = "fogot")
	public String fogot(Model model, @RequestParam("email") String email) {
		MessageChecking message = null;
		try {
			message = accountService.fogotPassword(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("message", message);
		return viewUserPages("../common/account-log.jsp");
	}

	@GetMapping(value = "account-log", params = "reset")
	public String reset() {
		return viewUserPages("../common/account-log.jsp");
	}

	@PostMapping(value = "account-log", params = "reset")
	public String reset(Model model, @RequestParam("password") String password, @RequestParam("email") String email) {
		MessageChecking message = null;
		try {
			message = accountService.resetPassword(password, email);

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("message", message);
		return viewUserPages("account/reset.jsp");
	}

}
