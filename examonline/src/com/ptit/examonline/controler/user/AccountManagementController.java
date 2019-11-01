package com.ptit.examonline.controler.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

@Controller
@RequestMapping("account-management")
public class AccountManagementController extends HelperController{
	
	@Autowired
	private AccountService accountService;

	@Autowired
	private PersonService personService;
	
	@Autowired
	private ExamService examService;
	
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
		PersonDTO dto = new PersonDTO();
		dto.setGender(true);
		model.addAttribute("personInfo", dto);

		model.addAttribute("btnTitle", "Edit Account Information");

		return viewUserPages("account/edit-accountinfor.jsp");
	}

	@PostMapping(value = "account-edit", params = "changepassword")
	public String changePassword(Model model,
			@RequestParam("username") String userName,
			@RequestParam("password") String password,
			@ModelAttribute(value="personInfo", binding=false) PersonDTO dto) {
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
	public String updatePersonInfo(Model model, @ModelAttribute("personInfo") PersonDTO infoDTO) {
		try {
			
			MessageChecking message = personService.updatePersonInfo(infoDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("btnTitle", "Edit Account Information");
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
