package com.ptit.examonline.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.examonline.dto.MessageChecking;
import com.ptit.examonline.dto.PersonDTO;

@Transactional
@Service
public interface PersonService {

	MessageChecking updatePersonInfo(PersonDTO infoDTO) throws Exception;

}
