/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhoang.service;

import com.huyhoang.dao.TestDaoIF;
import com.huyhoang.entity.Test;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Huy
 */
@Service
public class TestService implements TestServiceIF {

    @Autowired
    TestDaoIF testDaoIF;
    
    @Override
    public List<Test> getTests() {
        return (List<Test>) testDaoIF.findAll();
    }

    @Override
    public void saveTest(Test test) {
        testDaoIF.save(test);
    }

    @Override
    public void deleteTest(int quizCode) {
        testDaoIF.deleteById(quizCode);
    }

    @Override
    public Test getTest(int id) {
        Optional<Test> question = testDaoIF.findById(id);
	return question.isPresent() ? question.get() : null;
    } 

}
