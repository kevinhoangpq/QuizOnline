/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhoang.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Huy
 */

@Entity(name = "test")
public class Test implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int test_id;
    
    private String description;
    
    private String password;
    
    private int question_number;
    
    private String test_name;
    
    private int test_time;
    
    @ManyToOne
    @JoinColumn(name = "test_type_id")
    private TestType test_type;
    

    @ManyToMany
    @JoinTable(name = "test_question",
            joinColumns = {@JoinColumn(name = "test_id", referencedColumnName = "test_id")},
            inverseJoinColumns = {@JoinColumn(name = "question_id", referencedColumnName = "question_id")})
    List<Question> listQuestion;

    public Test() {
    }

    public Test(int test_id, String description, String password, int question_number, String test_name, int test_time, TestType test_type, List<Question> listQuestion) {
        this.test_id = test_id;
        this.description = description;
        this.password = password;
        this.question_number = question_number;
        this.test_name = test_name;
        this.test_time = test_time;
        this.test_type = test_type;
        this.listQuestion = listQuestion;
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

    public TestType getTest_type() {
        return test_type;
    }

    public void setTest_type(TestType test_type) {
        this.test_type = test_type;
    }

    public List<Question> getListQuestion() {
        return listQuestion;
    }

    public void setListQuestion(List<Question> listQuestion) {
        this.listQuestion = listQuestion;
    }

    

        
}
