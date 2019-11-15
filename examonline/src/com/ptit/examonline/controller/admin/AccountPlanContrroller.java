package com.ptit.examonline.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ptit.examonline.dto.AccountPlanDTO;
import com.ptit.examonline.dto.MessageChecking;
import com.ptit.examonline.helper.HelperController;
import com.ptit.examonline.service.AccountPlanService;

@Controller
@RequestMapping("admin/account-plan")
public class AccountPlanContrroller extends HelperController {

	@Autowired
	private AccountPlanService planService;

	@RequestMapping(value ="index")
	public String index() {
		return viewAdminPages("account-plan/index.jsp");
	}
	@RequestMapping("get-page")
	public String getPage(Model model, @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
		try {
			model.addAttribute("accountPlans", planService.getAccountPlans(pageNo, pageSize));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/account-plan/list";
	}
	
	@ResponseBody
	@RequestMapping("get-page-count")
	public String getPageCount(Model model, @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
		int pageCount = 0;
		try {
			int rowCount = planService.getAccountPlans().size();
			pageCount = (int) Math.ceil(1.0 * rowCount / pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return String.valueOf(pageCount);
	}
	
	@ResponseBody
	@RequestMapping("delete")
	public String delete(@RequestParam("accountPlanId") Long accountPlanId) {
		boolean result = false;
		try {
			result = planService.delete(accountPlanId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ""+result;
	}
	@ResponseBody
	@GetMapping("update")
	public String update(@RequestParam("accountPlanId") Long accountPlanId) {
		ObjectMapper mapper = new ObjectMapper();
		String result = "";
		try {
			AccountPlanDTO accountPlanDTO  = planService.getAccountPlanById(accountPlanId);
			 result = mapper.writeValueAsString(accountPlanDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@PostMapping("update")
	public String update(Model model,@RequestParam("accountPlanId") Long accountPlanId,
			@RequestParam("shortDescription") String shortDescription) {
		MessageChecking message = null;
		try {
			message  = planService.updatePlan(accountPlanId, shortDescription);
			model.addAttribute("status", message.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect: index.htm";
	}
	
	@PostMapping("insert")
	public String insert(Model model,@RequestParam("accountPlanId") Long accountPlanId, 
			@RequestParam("planCode") String planCode,
			@RequestParam("shortDescription") String shortDescription) {
		MessageChecking message = null;
		try {
			message  = planService.insertPlan(planCode, shortDescription);
			model.addAttribute("status", message.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect: index.htm";
	}
}
