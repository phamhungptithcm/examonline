package com.ptit.examonline.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.examonline.dto.AccountStatusDTO;
import com.ptit.examonline.dto.MessageChecking;
import com.ptit.examonline.entity.AccountStatus;

@Transactional
@Service
public interface AccountStatusService {
	public boolean delete(Long accountStatusId) throws Exception;
	public List<AccountStatus> getAccountStatuses() throws Exception;
	public AccountStatusDTO getAccountStatusById(Long accountStatusId) throws Exception;
	public MessageChecking updateStatus(Long accountStatusId, String shortDescription) throws Exception;
	public MessageChecking insertStatus(String accountStatusCode, String shortDescription) throws Exception;
	public List<AccountStatus> getAccountStatuses(int pageNo, int pageSize);
}
