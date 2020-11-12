/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhoang.service;

import com.huyhoang.entity.Question;

import java.util.List;
import java.util.Set;

/**
 *
 * @author Huy
 */
public interface QuestionServiceIF {
    public List<Question> getQuestions();
    public void saveQuestion(Question question);
    public void deleteQuestion(int id);
    public Question getQuestion(int id);
    public boolean isExist(Question question, List<Question> list);
}
