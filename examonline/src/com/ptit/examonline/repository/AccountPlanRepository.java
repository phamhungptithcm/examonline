package com.ptit.examonline.repository;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ptit.examonline.dao.AccountPlanDAO;
import com.ptit.examonline.entity.AccountPlan;


@Repository
@EnableTransactionManagement
public class AccountPlanRepository implements AccountPlanDAO{
	
	@Autowired
	SessionFactory factory;

	@Override
	public void insert(AccountPlan entity) throws Exception{
		factory.getCurrentSession().save(entity);
	}

	@Override
	public void update(AccountPlan entity) throws Exception{
		factory.getCurrentSession().merge(entity);
	}

	@Override
	public void delete(AccountPlan entity) throws Exception{
		factory.getCurrentSession().delete(entity);
	}

	@Override
	public void refresh(AccountPlan entity) throws Exception{
		factory.getCurrentSession().refresh(entity);
	}

	@Override
	public List<AccountPlan> getAccountPlans() throws Exception{
		String hql = "FROM AccountPlan WHERE isActive = true";
		Query query = factory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public AccountPlan getAccountPlanById(Long accountPlanId) throws Exception {
		String hql = "FROM AccountPlan WHERE accountPlanId=:accountPlanId";
		Query query= factory.getCurrentSession().createQuery(hql);
		query.setParameter("accountPlanId", accountPlanId);
		return (AccountPlan) query.uniqueResult();
	}

	@Override
	public AccountPlan getAccountPlanByCode(String planCode) {
		String hql = "FROM AccountPlan WHERE planCode=:planCode";
		Query query= factory.getCurrentSession().createQuery(hql);
		query.setParameter("planCode", planCode);
		return (AccountPlan) query.uniqueResult();
	}

}
