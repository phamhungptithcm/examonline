package com.ptit.examonline.dao;

import java.util.List;

import com.ptit.examonline.entity.Anwser;

public interface AnwserDAO {
	public void insert(Anwser entity);
	public void update(Anwser entity);
	public void delete(Anwser entity);
	public void refresh(Anwser entity);
	public List<Anwser> getAnswers();
}
