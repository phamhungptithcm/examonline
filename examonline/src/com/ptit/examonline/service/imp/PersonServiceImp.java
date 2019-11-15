package com.ptit.examonline.service.imp;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ptit.examonline.dao.AccountDAO;
import com.ptit.examonline.dao.PersonDAO;
import com.ptit.examonline.dto.MessageChecking;
import com.ptit.examonline.dto.PersonDTO;
import com.ptit.examonline.entity.Account;
import com.ptit.examonline.entity.Person;
import com.ptit.examonline.helper.HelperService;
import com.ptit.examonline.service.PersonService;

@Component
public class PersonServiceImp extends HelperService implements PersonService {

	@Autowired
	private PersonDAO personDAO;

	@Autowired
	private AccountDAO accountDAO;

	@Autowired
	HttpServletRequest request;
	private static Date date = new Date();
	private static Timestamp timestamp = new Timestamp(date.getTime());

	@Override
	public MessageChecking updatePersonInfo(PersonDTO personDTO) throws Exception {
		MessageChecking message = new MessageChecking();
		Person person = personDAO.getPersonById(personDTO.getPersonId());
		Account account = getCurrentAccount();
		if (person != null) {
			String gender = (personDTO.getGender() == true || personDTO.getGender() == null) ? "MALE" : "FEMALE";
			person.setLastName(personDTO.getLastName());
			person.setFirstName(personDTO.getFirstName());
			person.setAddress(personDTO.getAddress());
			person.setEmailAddress(personDTO.getEmail());
			person.setPhoneNumber(personDTO.getPhoneNum());
			person.setGender(gender);
			person.setModifiedBy(account.getUserName());
			person.setDateModified(timestamp);

			personDAO.update(person);

			message.setMessage("Update successfuly!");
			message.setStatus(true);

		} else {
			message.setMessage("Update fail!");
			message.setStatus(false);
		}

		return message;
	}

	@Override
	public List<Person> getPersons() throws Exception {
		return personDAO.getPersons();
	}

	@Override
	public PersonDTO getPerson(Long personId) throws Exception {
		Person person = personDAO.getPersonById(personId);
		PersonDTO dto = new PersonDTO();
		if (person != null) {
			dto.setPersonId(person.getPersonId());
			dto.setFirstName(person.getFirstName());
			dto.setLastName(person.getLastName());
			dto.setAddress(person.getAddress());
			dto.setEmail(person.getEmailAddress());
			dto.setGender("MALE".equals(person.getGender()) ? true : false);
			dto.setPhoneNum(person.getPhoneNumber());
		}
		return dto;
	}

	@Override
	public boolean updatePerson(PersonDTO personDTO) throws Exception {
		Person oldPerson = personDAO.getPersonById(personDTO.getPersonId());
		boolean result = false;
		if (oldPerson != null) {
			oldPerson.setFirstName(personDTO.getFirstName());
			oldPerson.setLastName(personDTO.getLastName());
			oldPerson.setEmailAddress(personDTO.getEmail());
			oldPerson.setPhoneNumber(personDTO.getPhoneNum());
			oldPerson.setAddress(personDTO.getAddress());
			oldPerson.setGender(personDTO.getGender() == true ? "MALE" : "FEMALE");
			oldPerson.setModifiedBy(getCurrentAccount().getUserName());
			oldPerson.setDateModified(timestamp);
			personDAO.update(oldPerson);
			result = true;
		}
		return result;
	}

	@Override
	public List<Person> getPersons(int pageNo, int pageSize) throws Exception {
		return personDAO.getPersons(pageNo, pageSize);
	}

	@Override
	public PersonDTO getPersonDTO() throws Exception {
		Account account = getCurrentAccount();
		PersonDTO dto = new PersonDTO();
		if (account != null) {
			Person person = account.getPerson();
			
			dto.setPersonId(person.getPersonId());
			dto.setFirstName(person.getFirstName());
			dto.setLastName(person.getLastName());
			dto.setEmail(person.getEmailAddress());
			Boolean gender = true;
			if(person.getGender() != null) {
				gender = person.getGender().equals("MALE");
			}
			dto.setGender(gender);
			dto.setPhoneNum(person.getPhoneNumber());
			dto.setAddress(person.getAddress());
		}
		return dto;
	}

}
