/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhoang.service;

import com.huyhoang.dao.QuestionDaoIF;
import com.huyhoang.entity.Question;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Huy
 */
@Service
public class QuestionService implements QuestionServiceIF {

    @Autowired
    QuestionDaoIF questionDaoIF;
    
    @Override
    public List<Question> getQuestions() {
        
        return (List<Question>) questionDaoIF.findAll();
    }

    @Override
    public void saveQuestion(Question question) {
        questionDaoIF.save(question);
    }

    @Override
    public void deleteQuestion(int id) {
        questionDaoIF.deleteById(id);
    }

    @Override
    public Question getQuestion(int id) {
        Optional<Question> question = questionDaoIF.findById(id);
	return question.isPresent() ? question.get() : null;
    }

	@Override
	public boolean isExist(Question question, List<Question> list) {
		boolean flag = false;
		for (Question qs : list) {
			if (question.getQuestion_id() == qs.getQuestion_id()) {
				flag = true;
				break;
			}
		}
		return flag;
	}
    
}
