package com.ptit.examonline.service.imp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ptit.examonline.dao.AccountDAO;
import com.ptit.examonline.dao.AccountPlanDAO;
import com.ptit.examonline.dao.AccountStatusDAO;
import com.ptit.examonline.dao.PersonDAO;
import com.ptit.examonline.dto.AccountMessage;
import com.ptit.examonline.dto.LoginInfoDTO;
import com.ptit.examonline.dto.NewAccountInfoDTO;
import com.ptit.examonline.dto.PersonInfoDTO;
import com.ptit.examonline.entity.Account;
import com.ptit.examonline.entity.Person;
import com.ptit.examonline.helper.Helper;
import com.ptit.examonline.helper.Mailer;
import com.ptit.examonline.service.AccountService;

@Component
public class AccountServiceImp extends Helper implements AccountService {

	@Autowired
	private AccountDAO accountDAO;

	@Autowired
	private AccountStatusDAO accountStatusDAO;

	@Autowired
	private AccountPlanDAO accountPlanDAO;

	@Autowired
	private PersonDAO personDAO;

	@Autowired
	HttpSession session;

	@Autowired
	Mailer mailer;

	@Autowired
	HttpServletRequest request;

	public AccountMessage signin(LoginInfoDTO loginInfoDTO) throws Exception {
		Account account = accountDAO.getAccount(loginInfoDTO.getUserName());
		String password = generateSecurePassword(loginInfoDTO.getPassword());
		AccountMessage message = new AccountMessage();
		if (account == null) {
			message.setMessage("Account information is not correct. Please check your username/password again!");
			message.setStatus(false);
		} else if (account.getAccountStatus().getAccoutStatusCode().equals("A")) {
			message.setMessage("This account is not actived. Please contact administrator!");
			message.setStatus(false);
		} else if (verifyUserPassword(loginInfoDTO.getPassword(), account.getPassword())) {
			message.setMessage("Account information is not correct. Please check your username/password again!");
			message.setStatus(false);
		} else {
			session.setAttribute("user", loginInfoDTO);

			message.setMessage("Succcessfuly");
			message.setStatus(true);
		}
		return message;
	}

	public AccountMessage signup(NewAccountInfoDTO account) throws Exception {
		AccountMessage message = new AccountMessage();
		Account user = accountDAO.getAccount(account.getUserName());
		if (user != null) {
			message.setMessage("The username already exists!");
			message.setStatus(false);
		} else {
			Account newAccount = new Account();
			Person person = new Person();
			person.setFirstName(account.getFirstName());
			person.setLastName(account.getLastName());
			person.setEmailAddress(account.getEmail());
			person.setPhoneNumber(account.getPhoneNum());
			person.setCreatedBy(account.getUserName());
			person.setModifiedBy(account.getUserName());

			personDAO.insert(person);

			newAccount.setUserName(account.getUserName());
			newAccount.setPassword(generateSecurePassword(account.getPassword()));
			newAccount.setAccountStatus(accountStatusDAO.getAccountStatusByStatusCode("P"));
			newAccount.setAccountPlan(accountPlanDAO.getAccountPlanByPlanCode("ST"));
			newAccount.setCreatedBy(account.getUserName());
			newAccount.setModifiedBy(account.getUserName());
			newAccount.setPerson(person);

			accountDAO.insert(newAccount);

			message.setMessage("Successfuly");
			message.setStatus(true);
		}

		return message;
	}

	@Override
	public PersonInfoDTO setPersonInfo(String userName) throws Exception {
		PersonInfoDTO infoDTO = new PersonInfoDTO();
		Account account = accountDAO.getAccount(userName);
		String fullname = account.getPerson().getFirstName() + " " + account.getPerson().getLastName();
		infoDTO.setAccountNumber(String.valueOf(account.getAccountNumber()));
		infoDTO.setAccountPlan(account.getAccountPlan().getShortDescription());
		infoDTO.setAccountStatus(account.getAccountStatus().getShortDescription());
		infoDTO.setFullName(fullname);
		infoDTO.setEmail(account.getPerson().getEmailAddress());
		infoDTO.setPhoneNum(account.getPerson().getPhoneNumber());
		infoDTO.setAddress(account.getPerson().getAddress());

		return infoDTO;
	}

	@Override
	public AccountMessage fogotPassword(String email) throws Exception {
		boolean status;
		String uri = "/examonline/account/account-log.htm?reset&email="+email;
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + uri;
		String link = "<a href=\"" + url + "\">Reset your password</a> \n";
		AccountMessage message = new AccountMessage();
		StringBuffer title = new StringBuffer("Hello, \n");
		StringBuffer content = new StringBuffer(
				"A request to reset your Hover account password was received. Click the button  to reset your password and "
						+ "sign into your ExamOnline account. This link is valid for one hour: \n");
		StringBuffer linkReset = new StringBuffer(link);
		StringBuffer endText = new StringBuffer(
				"You can safely disregard this email if you didn't request a password reset and your password will not be changed \n Thanks, \n ExamOnline");
		String contentSending = String.valueOf(title.append(content).append(linkReset).append(endText));
		if (email != null) {
			status = mailer.send(email, "Forgot password", contentSending);
			if (status) {
				message.setMessage("Please check mail to continue reseting your password!");
				message.setStatus(status);
			} else {
				message.setMessage("This action is failed that unknown reason.Please try again!");
				message.setStatus(status);
			}
		}
		return message;
	}

	@Override
	public AccountMessage resetPassword(String password, String email) throws Exception {
		Account account = accountDAO.getAcountByEmail(email);
		AccountMessage message = new AccountMessage();;
		if(account!=null) {
			account.setPassword(generateSecurePassword(password));
			accountDAO.update(account);
			message.setMessage("Update successfuly");
			message.setStatus(true);
		}
		message.setMessage("Update fail");
		message.setStatus(false);
		return message;
	}

	@Override
	public AccountMessage changePassword(String userName, String password) throws Exception {
		Account account = accountDAO.getAccount(userName);
		AccountMessage message = new AccountMessage();;
		if(account!=null) {
			account.setPassword(generateSecurePassword(password));
			accountDAO.update(account);
			message.setMessage("Update successfuly");
			message.setStatus(true);
		} else {
			message.setMessage("Update fail");
			message.setStatus(false);
		}
		
		return message;
	}


}
