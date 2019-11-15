package com.ptit.examonline.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.examonline.dto.AccountPlanDTO;
import com.ptit.examonline.dto.MessageChecking;
import com.ptit.examonline.entity.AccountPlan;

@Transactional
@Service
public interface AccountPlanService {
	public boolean delete(Long accountPlanId) throws Exception;

	public List<AccountPlan> getAccountPlans() throws Exception;

	public AccountPlanDTO getAccountPlanById(Long accountPlanId) throws Exception;

	public MessageChecking insertPlan(String planCode, String shortDescription);

	public MessageChecking updatePlan(Long accountPlanId, String shortDescription);

	public List<AccountPlan> getAccountPlans(int pageNo, int pageSize);
}
