/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhoang.dao;

import com.huyhoang.entity.TestType;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Huy
 */
public interface TestTypeDaoIF extends CrudRepository<TestType, String>{
    
}
