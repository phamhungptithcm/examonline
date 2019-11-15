package com.ptit.examonline.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ptit.examonline.dao.AccountDAO;
import com.ptit.examonline.entity.Account;


@Repository
@EnableTransactionManagement
public class AccountRepository implements AccountDAO{
	
	@Autowired
	SessionFactory factory;
	
	@Override
	public void insert(Account entity) {
		factory.getCurrentSession().save(entity);
	}

	@Override
	public void update(Account entity) {
		factory.getCurrentSession().merge(entity);
	}

	@Override
	public void delete(Account entity) {
		factory.getCurrentSession().delete(entity);
	}

	@Override
	public void refresh(Account entity) {
		factory.getCurrentSession().refresh(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Account> getAccounts() {
		String hql = "FROM Account";
		Query query= factory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public Account getAccount(String userName) {
		String hql = "FROM Account WHERE userName=:userName";
		Query query= factory.getCurrentSession().createQuery(hql);
		query.setParameter("userName", userName);
		return (Account)query.uniqueResult();
	}

	@Override
	public Account getAcountByEmail(String email) {
		String hql = "FROM Account WHERE person.emailAddress=:email";
		Query query= factory.getCurrentSession().createQuery(hql);
		query.setParameter("email", email);
		return (Account)query.uniqueResult();
	}

	@Override
	public Account getAccountByAccountNumber(Long accountNumber) {
		String hql = "FROM Account WHERE accountNumber=:accountNumber";
		Query query= factory.getCurrentSession().createQuery(hql);
		query.setParameter("accountNumber", accountNumber);
		return (Account)query.uniqueResult();
	}

	@Override
	public Account getAccountByUserName(String username) {
		String hql = "FROM Account WHERE userName=:username";
		Query query= factory.getCurrentSession().createQuery(hql);
		query.setParameter("username", username);
		return (Account)query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Account> getAccounts(int pageNo, int pageSize) {
		String hql = "FROM Account";
		Query query= factory.getCurrentSession().createQuery(hql);
		query.setFirstResult(pageNo*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	
}
