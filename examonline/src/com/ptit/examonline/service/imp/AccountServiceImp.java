package com.ptit.examonline.service.imp;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ptit.examonline.dao.AccountDAO;
import com.ptit.examonline.dao.AccountPlanDAO;
import com.ptit.examonline.dao.AccountStatusDAO;
import com.ptit.examonline.dao.PersonDAO;
import com.ptit.examonline.dto.AccountDTO;
import com.ptit.examonline.dto.LoginInfoDTO;
import com.ptit.examonline.dto.MessageChecking;
import com.ptit.examonline.dto.PersonDTO;
import com.ptit.examonline.entity.Account;
import com.ptit.examonline.entity.AccountPlan;
import com.ptit.examonline.entity.AccountStatus;
import com.ptit.examonline.entity.Person;
import com.ptit.examonline.helper.HelperConst;
import com.ptit.examonline.helper.HelperService;
import com.ptit.examonline.helper.Mailer;
import com.ptit.examonline.service.AccountService;

@Component
public class AccountServiceImp extends HelperService  implements AccountService {

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

	public MessageChecking signin(LoginInfoDTO user) throws Exception {
		Account account = accountDAO.getAccount(user.getUserName());
		MessageChecking message = new MessageChecking();
		if (account == null) {
			message.setMessage(HelperConst.ACCOUNTNOTFOUND);
			message.setStatus(false);
		} else {
			if (account.getAccountStatus().getAccoutStatusCode().equals("A")) {
				message.setMessage(HelperConst.ACCOUNTNOTACTIVE);
				message.setStatus(false);
			}
			if (user.getPassword().equals(account.getPassword()) == false) {
				message.setMessage(HelperConst.ACCOUNTNOTFOUND);
				message.setStatus(false);
			} else {
				boolean isAdmin = false;
				if(account.getAccountPlan().getAccountPlanId() == 3)  {
					isAdmin  = true;
				}
				message.setIsAdmin(isAdmin);
				user.setAdmin(isAdmin);
				session.setAttribute("user", user);
				message.setMessage("Succcessfuly");
				message.setStatus(true);
			}
		}
		return message;
	}

	public MessageChecking signup(AccountDTO account) throws Exception {
		MessageChecking message = new MessageChecking();
		Account user = accountDAO.getAccount(account.getUsername());
		if (user != null) {
			message.setMessage(HelperConst.ACCOUTNEXISTED);
			message.setStatus(false);
		} else {
			Account newAccount = new Account();
			Person person = new Person();
			person.setFirstName(account.getFirstName());
			person.setLastName(account.getLastName());
			person.setEmailAddress(account.getEmail());
			person.setPhoneNumber(account.getPhoneNum());
			person.setCreatedBy(account.getUsername());
			person.setModifiedBy(account.getUsername());

			personDAO.insert(person);
			
			newAccount.setUserName(account.getUsername());
			newAccount.setPassword(account.getPassword());
			newAccount.setAccountStatus(accountStatusDAO.getAccountStatusById((long)1)); // active
			newAccount.setAccountPlan(accountPlanDAO.getAccountPlanById((long)1)); // student
			newAccount.setCreatedBy(account.getUsername());
			newAccount.setModifiedBy(account.getUsername());
			newAccount.setPerson(person);

			accountDAO.insert(newAccount);

			message.setMessage("Successfuly");
			message.setStatus(true);
		}

		return message;
	}

	@Override
	public PersonDTO setPersonInfo(String userName) throws Exception {
		PersonDTO infoDTO = new PersonDTO();
		Account account = accountDAO.getAccount(userName);
		String fullname = account.getPerson().getFirstName() + " " + account.getPerson().getLastName();
		infoDTO.setAccountNumber(String.valueOf(account.getAccountNumber()));
		infoDTO.setAccountPlan(account.getAccountPlan().getShortDescription());
		infoDTO.setAccountStatus(account.getAccountStatus().getShortDescription());
		infoDTO.setFullName(fullname);
		infoDTO.setEmail(account.getPerson().getEmailAddress());
		infoDTO.setPhoneNum(account.getPerson().getPhoneNumber());
		infoDTO.setAddress(account.getPerson().getAddress());
		infoDTO.setDateOfBirth(new SimpleDateFormat("MM/dd/yyyy").format(account.getPerson().getDateCreated()));

		return infoDTO;
	}

	@Override
	public MessageChecking fogotPassword(String email) throws Exception {
		boolean status;
		String uri = "/examonline/account/account-log.htm?reset&email=" + email;
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + uri;
		String link = "<a href=\"" + url + "\">Reset your password</a> \n";
		MessageChecking message = new MessageChecking();
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
	public MessageChecking resetPassword(String password, String email) throws Exception {
		Account account = accountDAO.getAcountByEmail(email);
		MessageChecking message = new MessageChecking();
		;
		if (account != null) {
			account.setPassword(password);
			accountDAO.update(account);
			message.setMessage("Update successfuly");
			message.setStatus(true);
		}
		message.setMessage("Update fail");
		message.setStatus(false);
		return message;
	}

	@Override
	public MessageChecking changePassword(String userName, String password) throws Exception {
		Account account = accountDAO.getAccount(userName);
		MessageChecking message = new MessageChecking();
		;
		if (account != null) {
			account.setPassword(password);
			accountDAO.update(account);
			message.setMessage("Update successfuly");
			message.setStatus(true);
		} else {
			message.setMessage("Update fail");
			message.setStatus(false);
		}

		return message;
	}

	@Override
	public Account getAccount(String userName) {
		return accountDAO.getAccount(userName);
	}

	@Override
	public List<Account> getAccounts() throws Exception {
		return accountDAO.getAccounts();
	}

	@Override
	public AccountDTO getAccountByUsername(String username) {
		Account account = accountDAO.getAccount(username);
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setUsername(account.getUserName());
		accountDTO.setPassword(account.getPassword());
		return accountDTO;
	}

	@Override
	public AccountDTO delete(Long accountNumber) {
		Account account = accountDAO.getAccountByAccountNumber(accountNumber);
		AccountDTO accountDTO = null;
		try {
			AccountStatus accountStatus = accountStatusDAO.getAccountStatusById((long)3);
			account.setAccountStatus(accountStatus);
			accountDAO.update(account);
			accountDTO = new AccountDTO();
			accountDTO.setAccountNumber(account.getAccountNumber());
			accountDTO.setAccountStatus(account.getAccountStatus().getShortDescription());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accountDTO;
	}

	@Override
	public AccountDTO getAccountByAccountNumber(Long accountNumber) throws Exception {
		Account account = accountDAO.getAccountByAccountNumber(accountNumber);
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountNumber(account.getAccountNumber());
		accountDTO.setUsername(account.getUserName());
		accountDTO.setPassword(account.getPassword());
		accountDTO.setAccountPlanId(account.getAccountPlan().getAccountPlanId());
		accountDTO.setAccountStatusId(account.getAccountStatus().getAccountStatusId());
		return accountDTO;
	}
	
	@Override
	public MessageChecking updateAccount(AccountDTO accountDTO) throws Exception {
		MessageChecking message = new MessageChecking();
		message.setMessage("Fail");
		message.setStatus(false);
		
		Account account = accountDAO.getAccountByAccountNumber(accountDTO.getAccountNumber());
		AccountStatus accountStatus = accountStatusDAO.getAccountStatusById(accountDTO.getAccountStatusId());
		AccountPlan accountPlan = accountPlanDAO.getAccountPlanById(accountDTO.getAccountPlanId());
		
		if(account != null) {
			account.setPassword(accountDTO.getPassword());
			account.setAccountPlan(accountPlan);
			account.setAccountStatus(accountStatus);
			
			accountDAO.update(account);
			message.setMessage("Updated");
			message.setStatus(true);
			
		}
		
		return message;
	}

	@Override
	public MessageChecking addAnNewAccount(AccountDTO accountDTO) throws Exception {
		MessageChecking message = new MessageChecking();
		message.setMessage("Account is exited");
		message.setStatus(false);
		
		Account account = accountDAO.getAccountByUserName(accountDTO.getUsername());
		AccountStatus accountStatus = accountStatusDAO.getAccountStatusById(accountDTO.getAccountStatusId());
		AccountPlan accountPlan = accountPlanDAO.getAccountPlanById(accountDTO.getAccountPlanId());
		
		if(account == null) {
			Person person = new Person();
			person.setAddress(getCurrentAccount().getPerson().getAddress());
			person.setCreatedBy(getCurrentAccount().getUserName());
			person.setModifiedBy(getCurrentAccount().getUserName());
			person.setEmailAddress(accountDTO.getUsername()+"@gmail.com");
			person.setFirstName(getCurrentAccount().getPerson().getFirstName());
			person.setLastName(getCurrentAccount().getPerson().getLastName());
			person.setGender(getCurrentAccount().getPerson().getGender());
			person.setPhoneNumber(getCurrentAccount().getPerson().getPhoneNumber());
			personDAO.insert(person);
			Account account2 = new Account();
			account2.setAccountPlan(accountPlan);
			account2.setAccountStatus(accountStatus);
			account2.setUserName(accountDTO.getUsername());
			account2.setPerson(person);
			account2.setPassword(accountDTO.getPassword());
			account2.setCreatedBy(getCurrentAccount().getUserName());
			account2.setModifiedBy(getCurrentAccount().getUserName());
			
			
			accountDAO.insert(account2);
			message.setMessage("Successfull");
			message.setStatus(true);
		}
		
		return message;
	}

	@Override
	public List<Account> getAccounts(int pageNo, int pageSize) throws Exception {
		return accountDAO.getAccounts(pageNo,pageSize);
	}

}
