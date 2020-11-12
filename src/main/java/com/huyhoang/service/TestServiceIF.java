/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhoang.service;

import com.huyhoang.entity.Test;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Huy
 */
public interface TestServiceIF {
    public List<Test> getTests();
    public void saveTest(Test test);
    public void deleteTest(int quizCode);
    public Test getTest(int quizCode);
    
}
