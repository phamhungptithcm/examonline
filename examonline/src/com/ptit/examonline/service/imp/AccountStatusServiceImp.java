package com.ptit.examonline.service.imp;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ptit.examonline.dao.AccountDAO;
import com.ptit.examonline.dao.AccountStatusDAO;
import com.ptit.examonline.dto.AccountStatusDTO;
import com.ptit.examonline.dto.LoginInfoDTO;
import com.ptit.examonline.dto.MessageChecking;
import com.ptit.examonline.entity.Account;
import com.ptit.examonline.entity.AccountStatus;
import com.ptit.examonline.service.AccountStatusService;

@Component
public class AccountStatusServiceImp implements AccountStatusService{
	@Autowired
	private AccountStatusDAO statusDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	HttpSession session;

	@Override
	public boolean delete(Long accountStatusId) throws Exception {
		AccountStatus accountStatus= statusDAO.getAccountStatusById(accountStatusId);
		boolean result = true;
		try {
			accountStatus.setActive(false);
			statusDAO.update(accountStatus);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	@Override
	public AccountStatus update(Long accountStatusId) throws Exception {
		AccountStatus accountStatus= statusDAO.getAccountStatusById(accountStatusId);
		
		return null;
	}

	@Override
	public AccountStatus save(Long accountStatusId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountStatus> getAccountStatuses() throws Exception {
		return statusDAO.getAccountStatuses();
	}

	@Override
	public AccountStatusDTO getAccountStatusById(Long accountStatusId) throws Exception {
		AccountStatus accountStatus =  statusDAO.getAccountStatusById(accountStatusId);
		
		return new AccountStatusDTO(accountStatus.getAccountStatusId(),
				accountStatus.getAccoutStatusCode(), accountStatus.getShortDescription());
	}

	@Override
	public MessageChecking updateStatus(Long accountStatusId, String shortDescription) throws Exception {
		AccountStatus accountStatus =  statusDAO.getAccountStatusById(accountStatusId);
		MessageChecking message = new MessageChecking();
		message.setStatus(false);
		if (accountStatus != null) {
			accountStatus.setShortDescription(shortDescription);
			statusDAO.update(accountStatus);
			message.setStatus(true);
		}
		return message;
	}

	@Override
	public MessageChecking insertStatus(String accountStatusCode, String shortDescription) throws Exception {
		AccountStatus accountStatus =  statusDAO.getAccountStatusByCode(accountStatusCode.trim());
		MessageChecking messageChecking =  new MessageChecking();
		messageChecking.setStatus(false);
		if(accountStatus == null) {
			AccountStatus newAccountStatus = new AccountStatus();
			newAccountStatus.setAccoutStatusCode(accountStatusCode);
			newAccountStatus.setShortDescription(shortDescription);
			
			newAccountStatus.setCreatedBy(getCurrentAccount().getUserName());
			newAccountStatus.setModifiedBy(getCurrentAccount().getUserName());
			newAccountStatus.setActive(true);
			
			statusDAO.insert(newAccountStatus);
			messageChecking.setStatus(true);
		}
		return messageChecking;
	}

	private Account getCurrentAccount() throws Exception {
		LoginInfoDTO loginInfoDTO = (LoginInfoDTO) session.getAttribute("user");
		
		return accountDAO.getAccount(loginInfoDTO.getUserName());
	}
}
