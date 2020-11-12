/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhoang.service;

import com.huyhoang.entity.TestType;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Huy
 */
public interface TestTypeServiceIF {
    public List<TestType> getTestTypes();
    public TestType getTestType(String id);
    
}
