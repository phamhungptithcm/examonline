package com.ptit.examonline.service.imp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.examonline.dao.AccountDAO;
import com.ptit.examonline.dao.PersonDAO;
import com.ptit.examonline.dto.AccountMessage;
import com.ptit.examonline.dto.LoginInfoDTO;
import com.ptit.examonline.dto.PersonInfoDTO;
import com.ptit.examonline.entity.Account;
import com.ptit.examonline.entity.Person;
import com.ptit.examonline.service.PersonService;

@Component
public class PersonServiceImp implements PersonService{
	
	@Autowired
	private PersonDAO personDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	HttpServletRequest request;

	@Override
	public AccountMessage updatePersonInfo(PersonInfoDTO infoDTO) throws Exception {
		HttpSession session = request.getSession();
		
		LoginInfoDTO loginInfoDTO = (LoginInfoDTO) session.getAttribute("user");
		
		Account account = accountDAO.getAccount(loginInfoDTO.getUserName());
		AccountMessage message = new AccountMessage();
		if(account != null) {
			Person person = personDAO.getPersonById(account.getPerson().getPersonId());
			String gender = infoDTO.getGender() == true ? "MALE":"FEMALE";
			person.setLastName(infoDTO.getLastName());
			person.setFirstName(infoDTO.getFirstName());
			person.setAddress(infoDTO.getAddress());
			person.setEmailAddress(infoDTO.getEmail());
			person.setPhoneNumber(infoDTO.getPhoneNum());
			person.setGender(gender);
			person.setModifiedBy(loginInfoDTO.getUserName());
			
			personDAO.update(person);
			
			message.setMessage("Update successfuly!");
			message.setStatus(true);
			
		} else {
			message.setMessage("Update fail!");
			message.setStatus(false);
		}
		
		return message;
	}
}
