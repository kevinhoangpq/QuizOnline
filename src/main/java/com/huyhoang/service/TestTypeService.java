/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhoang.service;

import com.huyhoang.dao.TestTypeDaoIF;
import com.huyhoang.entity.TestType;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Huy
 */
@Service
public class TestTypeService implements TestTypeServiceIF{
    @Autowired
    TestTypeDaoIF testTypeDaoIF;
    
    @Override
     public List<TestType> getTestTypes() {
        return (List<TestType>) testTypeDaoIF.findAll();
    }

    @Override
    public TestType getTestType(String id) {
        Optional<TestType> testType = testTypeDaoIF.findById(id);
        return testType.isPresent() ? testType.get() : null;
    }
}
