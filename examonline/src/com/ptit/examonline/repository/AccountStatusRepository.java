package com.ptit.examonline.repository;

import java.util.List;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<AccountStatus> getAccountStatuses() throws Exception {
		String hql = "FROM AccountStatus WHERE isActive = 1";
		Query query = factory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public AccountStatus getAccountStatusById(Long accountStatusId) throws Exception {
		String hql = "FROM AccountStatus WHERE isActive = 1 AND accountStatusId=:id";
		Query query = factory.getCurrentSession().createQuery(hql);
		query.setParameter("id", accountStatusId);
		return (AccountStatus) query.uniqueResult();
	}

	@Override
	public AccountStatus getAccountStatusByCode(String statusCode) throws Exception {
		String hql = "FROM AccountStatus WHERE isActive = 1 AND accoutStatusCode=:statusCode";
		Query query = factory.getCurrentSession().createQuery(hql);
		query.setParameter("statusCode", statusCode);
		return (AccountStatus) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AccountStatus> getAccountStatuses(int pageNo, int pageSize) {
		String hql = "FROM AccountStatus WHERE isActive = 1";
		Query query = factory.getCurrentSession().createQuery(hql);
		query.setFirstResult(pageNo * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}
}
