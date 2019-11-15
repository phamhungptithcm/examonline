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
import com.ptit.examonline.dto.AccountStatusDTO;
import com.ptit.examonline.dto.MessageChecking;
import com.ptit.examonline.helper.HelperController;
import com.ptit.examonline.service.AccountStatusService;

@Controller
@RequestMapping("admin/account-status")
public class AccountStatusContrroller extends HelperController {

	@Autowired
	private AccountStatusService statusService;

	@RequestMapping(value = "index")
	public String index() {
		return viewAdminPages("account-status/index.jsp");
	}
	
	@RequestMapping("get-page")
	public String getPage(Model model, @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
		try {
			model.addAttribute("accountStatuses", statusService.getAccountStatuses(pageNo, pageSize));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/account-status/list";
	}
	
	@ResponseBody
	@RequestMapping("get-page-count")
	public String getPageCount(Model model, @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
		int pageCount = 0;
		try {
			int rowCount = statusService.getAccountStatuses().size();
			pageCount = (int) Math.ceil(1.0 * rowCount / pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return String.valueOf(pageCount);
	}
	
	
	@ResponseBody
	@RequestMapping("delete")
	public String delete(@RequestParam("accountStatusId") Long accountStatusId) {
		boolean result = false;
		try {
			result = statusService.delete(accountStatusId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "" + result;
	}

	@ResponseBody
	@GetMapping("update")
	public String update(@RequestParam("accountStatusId") Long accountStatusId) {
		ObjectMapper mapper = new ObjectMapper();
		String result = "";
		try {
			AccountStatusDTO accountStatus = statusService.getAccountStatusById(accountStatusId);
			 result = mapper.writeValueAsString(accountStatus);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@PostMapping("update")
	public String update(Model model, @RequestParam("accountStatusId") Long accountStatusId,
			@RequestParam("shortDescription") String shortDescription) {
			MessageChecking message = null;
			try {
				 message = statusService.updateStatus(accountStatusId,shortDescription);
				model.addAttribute("status", message.getStatus());
			} catch (Exception e) {
				e.printStackTrace();
			}
		return "redirect: index.htm";
	}
	
	@PostMapping("insert")
	public String insert(Model model, @RequestParam("accountStatusId") Long accountStatusId,
			@RequestParam("code") String accountStatusCode,
			@RequestParam("shortDescription") String shortDescription) {
			MessageChecking message = null;
			try {
				 message = statusService.insertStatus(accountStatusCode,shortDescription);
				model.addAttribute("status", message.getStatus());
			} catch (Exception e) {
				e.printStackTrace();
			}
		return "redirect: index.htm";
	}
	
	
	
}
