/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhoang.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

/**
 *
 * @author Huy
 */

@Entity(name = "question")
public class Question implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int question_id;
    
    @Size(max = 100, message = "answer 1 must be less than equal 100 character")
    private String answer_1;
    
    @Size(max = 100, message = "answer 2 must be less than equal 100 character")
    private String answer_2;
    
    @Size(max = 100, message = "answer 3 must be less than equal 100 character")
    private String answer_3;
    
    @Size(max = 1000, message = "content must be less than equal 1000 character")
    private String content;
    
    @Size(max = 100, message = "correct answer must be less than equal 100 character")
    private String correct_answer;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "test_question",
            joinColumns = {@JoinColumn(name = "question_id", referencedColumnName = "question_id")},
            inverseJoinColumns = {@JoinColumn(name = "test_id", referencedColumnName = "test_id")})
    List<Test> listTest;

    public Question() {
    }

    public Question(int question_id, String answer_1, String answer_2, String answer_3, String content, String correct_answer, List<Test> listTest) {
        this.question_id = question_id;
        this.answer_1 = answer_1;
        this.answer_2 = answer_2;
        this.answer_3 = answer_3;
        this.content = content;
        this.correct_answer = correct_answer;
        this.listTest = listTest;
    }
    
    
    

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getAnswer_1() {
        return answer_1;
    }

    public void setAnswer_1(String answer_1) {
        this.answer_1 = answer_1;
    }

    public String getAnswer_2() {
        return answer_2;
    }

    public void setAnswer_2(String answer_2) {
        this.answer_2 = answer_2;
    }

    public String getAnswer_3() {
        return answer_3;
    }

    public void setAnswer_3(String answer_3) {
        this.answer_3 = answer_3;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public List<Test> getListTest() {
        return listTest;
    }

    public void setListTest(List<Test> listTest) {
        this.listTest = listTest;
    }
    
    
}
