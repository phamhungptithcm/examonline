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
import com.ptit.examonline.dto.AccountDTO;
import com.ptit.examonline.dto.MessageChecking;
import com.ptit.examonline.helper.HelperController;
import com.ptit.examonline.service.AccountPlanService;
import com.ptit.examonline.service.AccountService;
import com.ptit.examonline.service.AccountStatusService;

@Controller
@RequestMapping("admin/account-management")
public class AccountAdminController extends HelperController{
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountStatusService accountStatusService;
	
	@Autowired
	private AccountPlanService accountPlanService;
	
	@RequestMapping(value ="index")
	public String index(Model model) {
		try {
			model.addAttribute("accountStatuses",accountStatusService.getAccountStatuses());
			model.addAttribute("accountPlans",accountPlanService.getAccountPlans());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewAdminPages("account/index.jsp");
	}
	
	@RequestMapping("get-page")
	public String getPage(Model model, @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
		System.out.println(pageNo + "-" + pageSize);
		try {
			model.addAttribute("accounts", accountService.getAccounts(pageNo, pageSize));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/account/list";
	}
	@ResponseBody
	@RequestMapping("delete")
	public String delete(@RequestParam("accountNumber") Long accountNumber) {
		String result = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			AccountDTO accountDTO = accountService.delete(accountNumber);
			result = mapper.writeValueAsString(accountDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@ResponseBody
	@GetMapping("update")
	public String update(@RequestParam("accountNumber") Long accountNumber) {
		
		ObjectMapper mapper = new ObjectMapper();
		String result = "";
		try {
			AccountDTO accountDTO  = accountService.getAccountByAccountNumber(accountNumber);
			 result = mapper.writeValueAsString(accountDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@PostMapping("update")
	public String update(Model model,@RequestParam("accountNumber") Long accountNumber,
			@RequestParam("password") String password,
			@RequestParam("accountStatusId") Long accountStatusId,
			@RequestParam("accountPlanId") Long accountPlanId) {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountNumber(accountNumber);
		accountDTO.setAccountPlanId(accountPlanId);
		accountDTO.setAccountStatusId(accountStatusId);
		accountDTO.setPassword(password);
		MessageChecking message = null;
		try {
			 message =  accountService.updateAccount(accountDTO);
			 model.addAttribute("status", message.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect: index.htm";
	}
	@PostMapping("insert")
	public String insert(Model model,@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("accountStatusId") Long accountStatusId,
			@RequestParam("accountPlanId") Long accountPlanId) {
		System.out.println(username + " -" + password + " - " + accountPlanId +" - " +accountStatusId);
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setUsername(username);
		accountDTO.setAccountPlanId(accountPlanId);
		accountDTO.setAccountStatusId(accountStatusId);
		accountDTO.setPassword(password);
		MessageChecking message = null;
		try {
			 message =  accountService.addAnNewAccount(accountDTO);
			 model.addAttribute("status", message.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect: index.htm";
	}
	
	@ResponseBody
	@RequestMapping("get-page-count")
	public String getPageCount(Model model, @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
		int pageCount = 0;
		try {
			int rowCount = accountService.getAccounts().size();
			pageCount = (int) Math.ceil(1.0 * rowCount / pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return String.valueOf(pageCount);
	}
}
