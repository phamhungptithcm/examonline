package com.ptit.examonline.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.examonline.dto.MessageChecking;
import com.ptit.examonline.dto.PersonDTO;
import com.ptit.examonline.entity.Person;

@Transactional
@Service
public interface PersonService {

	MessageChecking updatePersonInfo(PersonDTO infoDTO) throws Exception;
	
	List<Person> getPersons() throws Exception;

	PersonDTO getPerson(Long personId) throws Exception;

	boolean updatePerson(PersonDTO personDTO) throws Exception;

	List<Person> getPersons(int pageNo, int pageSize) throws Exception;

	PersonDTO getPersonDTO() throws Exception;

}
