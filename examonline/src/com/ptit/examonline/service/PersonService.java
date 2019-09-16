package com.ptit.examonline.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptit.examonline.dto.AccountMessage;
import com.ptit.examonline.dto.PersonInfoDTO;

@Transactional
@Service
public interface PersonService {

	AccountMessage updatePersonInfo(PersonInfoDTO infoDTO) throws Exception;

}
