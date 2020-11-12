/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhoang.entity;

import java.util.List;

/**
 *
 * @author Huy
 */
public class TestModel {

    private int test_id;
    
    private String description;
    
    private String password;
    
    private int question_number;
    
    private String test_name;
    
    private int test_time;
    
    private String test_type_id;
    
    private List<Integer> list_question_id;

    public TestModel() {
    }

    public TestModel(int test_id, String description, String password, int question_number, String test_name, int test_time, String test_type_id, List<Integer> list_question_id) {
        this.test_id = test_id;
        this.description = description;
        this.password = password;
        this.question_number = question_number;
        this.test_name = test_name;
        this.test_time = test_time;
        this.test_type_id = test_type_id;
        this.list_question_id = list_question_id;
    }

    public int getTest_id() {
        return test_id;
    }

    public void setTest_id(int test_id) {
        this.test_id = test_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getQuestion_number() {
        return question_number;
    }

    public void setQuestion_number(int question_number) {
        this.question_number = question_number;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public int getTest_time() {
        return test_time;
    }

    public void setTest_time(int test_time) {
        this.test_time = test_time;
    }

    public String getTest_type_id() {
        return test_type_id;
    }

    public void setTest_type_id(String test_type_id) {
        this.test_type_id = test_type_id;
    }

    public List<Integer> getList_question_id() {
        return list_question_id;
    }

    public void setList_question_id(List<Integer> list_question_id) {
        this.list_question_id = list_question_id;
    }
    
    
}
