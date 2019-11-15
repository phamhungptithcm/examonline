package com.ptit.examonline.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ptit.examonline.dto.PersonDTO;
import com.ptit.examonline.helper.HelperController;
import com.ptit.examonline.service.PersonService;
import com.ptit.examonline.validation.PersonDTOValidation;

@Controller
@RequestMapping("admin/person")
public class PersonController extends HelperController {

	@Autowired
	private PersonService personService;

	@Autowired
	private PersonDTOValidation personDTOValidation;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(personDTOValidation);
	}

	@RequestMapping("index")
	public String index() {
		return viewAdminPages("person/index.jsp");
	}

	@RequestMapping("get-page")
	public String getPage(Model model, @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		try {
			model.addAttribute("persons", personService.getPersons(pageNo, pageSize));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/person/list";
	}

	@ResponseBody
	@RequestMapping("get-page-count")
	public String getPageCount(Model model, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		int pageCount = 0;
		try {
			int rowCount = personService.getPersons().size();
			pageCount = (int) Math.ceil(1.0 * rowCount / pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return String.valueOf(pageCount);
	}

	@RequestMapping("edit")
	public String edit(Model model, @RequestParam("id") Long personId) {
		try {
			model.addAttribute("personDTO", personService.getPerson(personId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewAdminPages("person/update.jsp");
	}

	@PostMapping("edit")
	public String edit(Model model, @ModelAttribute("personDTO") @Validated PersonDTO personDTO, BindingResult result) {
		try {
			model.addAttribute("status", personService.updatePerson(personDTO));
			if (result.hasErrors()) {
				return viewAdminPages("person/update.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return viewAdminPages("person/update.jsp");
		}
		return "redirect: index.htm";
	}
}
