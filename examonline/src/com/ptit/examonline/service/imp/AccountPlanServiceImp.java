package com.ptit.examonline.service.imp;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ptit.examonline.dao.AccountDAO;
import com.ptit.examonline.dao.AccountPlanDAO;
import com.ptit.examonline.dto.AccountPlanDTO;
import com.ptit.examonline.dto.LoginInfoDTO;
import com.ptit.examonline.dto.MessageChecking;
import com.ptit.examonline.entity.Account;
import com.ptit.examonline.entity.AccountPlan;
import com.ptit.examonline.service.AccountPlanService;

@Component
public class AccountPlanServiceImp implements AccountPlanService{
	@Autowired
	private AccountPlanDAO accountPlanDAO;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	private AccountDAO accountDAO;

	@Override
	public boolean delete(Long accountPlanId) throws Exception {
		boolean result = false;
		AccountPlan accountPlan = accountPlanDAO.getAccountPlanById(accountPlanId);
		try {
			accountPlan.setActive(false);
			accountPlanDAO.update(accountPlan);
			result= true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public AccountPlan update(Long accountPlanId) throws Exception {
		return null;
	}

	@Override
	public AccountPlan save(Long accountPlanId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountPlan> getAccountPlans() throws Exception {
		return accountPlanDAO.getAccountPlans();
	}

	@Override
	public AccountPlanDTO getAccountPlanById(Long accountPlanId) throws Exception {
		AccountPlan accountPlan = accountPlanDAO.getAccountPlanById(accountPlanId);
		return new AccountPlanDTO(accountPlan.getAccountPlanId(), accountPlan.getPlanCode(), accountPlan.getShortDescription());
	}

	@Override
	public MessageChecking insertPlan(String planCode, String shortDescription) {
		MessageChecking message = new MessageChecking();
		message.setStatus(false);
		try {
			AccountPlan accountPlan = accountPlanDAO.getAccountPlanByCode(planCode);
			
			if(accountPlan == null) {
				AccountPlan newAccountPlan = new AccountPlan();
				
				newAccountPlan.setShortDescription(shortDescription);
				newAccountPlan.setPlanCode(planCode);
				newAccountPlan.setActive(true);
				newAccountPlan.setModifiedBy(getCurrentAccount().getUserName());
				newAccountPlan.setCreatedBy(getCurrentAccount().getUserName());
				accountPlanDAO.insert(newAccountPlan);
				message.setStatus(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public MessageChecking updatePlan(Long accountPlanId, String shortDescription) {
		MessageChecking message = new MessageChecking();
		message.setStatus(false);
		try {
			AccountPlan accountPlan = accountPlanDAO.getAccountPlanById(accountPlanId);
			
			if(accountPlan != null) {
				accountPlan.setShortDescription(shortDescription);
				accountPlanDAO.update(accountPlan);
				message.setStatus(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return message;
	}
	private Account getCurrentAccount() throws Exception {
		LoginInfoDTO loginInfoDTO = (LoginInfoDTO) session.getAttribute("user");
		
		return accountDAO.getAccount(loginInfoDTO.getUserName());
	}
}
