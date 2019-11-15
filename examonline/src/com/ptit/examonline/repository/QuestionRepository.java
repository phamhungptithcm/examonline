package com.ptit.examonline.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ptit.examonline.dao.QuestionDAO;
import com.ptit.examonline.entity.Question;

@Repository
@EnableTransactionManagement
public class QuestionRepository implements QuestionDAO {

	@Autowired
	SessionFactory factory;

	@Override
	public void insert(Question entity) {
		factory.getCurrentSession().save(entity);
	}

	@Override
	public void update(Question entity) {
		factory.getCurrentSession().update(entity);

	}

	@Override
	public void delete(Question entity) {
		factory.getCurrentSession().delete(entity);

	}

	@Override
	public void refresh(Question entity) {
		factory.getCurrentSession().refresh(entity);

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getQuestions() {
		String hql = "FROM Question";
		Query query = factory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getQuestions(int pageNo, int pageSize) {
		String hql = "FROM Question ";
		Query query = factory.getCurrentSession().createQuery(hql);
		query.setFirstResult(pageNo * pageSize);
		query.setMaxResults(pageSize);
		List<Question> questions = query.list();
		return questions;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getQuestions(int pageNo, int pageSize, int level) {
		String hql = "FROM Question WHERE level=:level";
		Query query = factory.getCurrentSession().createQuery(hql);
		query.setParameter("level", level);
		query.setFirstResult(pageNo * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getQuestionsRandom(Integer level) {
		String hql = "FROM Question q WHERE q.level=:level";
		Query query = factory.getCurrentSession().createQuery(hql);
		query.setParameter("level", level);
		return getRandomList(query.list());
	}

	private List<Question> getRandomList(List<Question> questions) {
		int numQuestion = 10;
		Random random = new Random();
		List<Question> result = new ArrayList<Question>();
		try {
			for (int i = 0; i < numQuestion; i++) {
		        int randomIndex = random.nextInt(questions.size());
		        result.add(questions.get(randomIndex));
		        questions.remove(randomIndex);
		    }
		} catch (Exception e) {
			System.out.println("List question is empty. Please check your data!");
		}
		
		return result;

	}

	@Override
	public Question getQuestionByQuestionId(Long questionId) {
		String hql = "FROM Question q WHERE q.questionId=:questionId";
		Query query = factory.getCurrentSession().createQuery(hql);
		query.setParameter("questionId", questionId);
		return (Question) query.uniqueResult();
	}
}
