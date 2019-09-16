package com.ptit.examonline.repository;

import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ptit.examonline.dao.AccountStatusDAO;
import com.ptit.examonline.entity.AccountStatus;


@Repository
@EnableTransactionManagement
public class AccountStatusRepository implements AccountStatusDAO {

	@Autowired
	SessionFactory factory;

	@Override
	public void insert(AccountStatus entity) throws Exception {
		factory.getCurrentSession().save(entity);

	}

	@Override
	public void update(AccountStatus entity) throws Exception {
		factory.getCurrentSession().merge(entity);
	}

	@Override
	public void delete(AccountStatus entity) throws Exception {
		factory.getCurrentSession().delete(entity);
	}

	@Override
	public void refresh(AccountStatus entity) throws Exception {
		factory.getCurrentSession().refresh(entity);
	}

	@Override
	public Set<AccountStatus> getAccountStatuses() throws Exception {
		String hql = "FROM AccountStatus";
		Query query = factory.getCurrentSession().createQuery(hql);
		return (Set<AccountStatus>) query.list();
	}

	@Override
	public AccountStatus getAccountStatusByStatusCode(String code) throws Exception {
		String hql = "FROM AccountStatus WHERE accoutStatusCode=:code";
		Query query= factory.getCurrentSession().createQuery(hql);
		query.setParameter("code", code);
		return (AccountStatus) query.uniqueResult();
	}
}
