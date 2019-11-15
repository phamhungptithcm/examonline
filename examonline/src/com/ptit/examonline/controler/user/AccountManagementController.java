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

import com.ptit.examonline.dto.MessageChecking;
import com.ptit.examonline.dto.PersonDTO;
import com.ptit.examonline.helper.HelperController;
import com.ptit.examonline.service.AccountService;
import com.ptit.examonline.service.ExamService;
import com.ptit.examonline.service.PersonService;
import com.ptit.examonline.validation.PersonDTOValidation;

@Controller
@RequestMapping("account-management")
public class AccountManagementController extends HelperController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private PersonService personService;

	@Autowired
	private ExamService examService;

	@Autowired
	PersonDTOValidation personDTOValidation;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(personDTOValidation);
	}

	@GetMapping(value = "account-overview")
	public String accountOverview(Model model) {
		model.addAttribute("btnTitle", "Acount Overview");
		try {
			model.addAttribute("exams", examService.getExams());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewUserPages("account/overview.jsp");
	}

	@GetMapping(value = "account-edit")
	public String editAccount(Model model) {
		try {
			model.addAttribute("personDTO", personService.getPersonDTO());
			model.addAttribute("btnTitle", "Edit Account Information");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return viewUserPages("account/edit-accountinfor.jsp");
	}

	@PostMapping(value = "account-edit", params = "changepassword")
	public String changePassword(Model model, @RequestParam("username") String userName,
			@RequestParam("password") String password,
			@ModelAttribute(value = "personDTO", binding = false) PersonDTO personDTO) {
		MessageChecking message = null;
		try {
			message = accountService.changePassword(userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("btnTitle", "Edit Account Information");
		model.addAttribute("message", message);

		return viewUserPages("account/edit-accountinfor.jsp");
	}

	@PostMapping(value = "account-edit", params = "updateinfo")
	public String updatePersonInfo(Model model, @ModelAttribute("personDTO") @Validated PersonDTO personDTO,
			BindingResult result) {
		MessageChecking message = null;
		if (result.hasErrors()) {
			return viewUserPages("account/edit-accountinfor.jsp");
		}
		try {
			message = personService.updatePersonInfo(personDTO);
			model.addAttribute("btnTitle", "Edit Account Information");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewUserPages("account/edit-accountinfor.jsp");
	}

	@GetMapping(value = "exam-result")
	public String getTestRessult(Model model, @RequestParam("examId") Long examId) {
		try {
			model.addAttribute("resultDTO", examService.getResults(examId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewUserPages("account/test-result.jsp");
	}
}
