/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhoang.controller;

import com.huyhoang.entity.Question;
import com.huyhoang.entity.Test;
import com.huyhoang.entity.TestModel;
import com.huyhoang.entity.TestType;
import com.huyhoang.service.QuestionServiceIF;
import com.huyhoang.service.TestServiceIF;
import com.huyhoang.service.TestTypeServiceIF;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Huy
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestServiceIF testService;

    @Autowired
    TestTypeServiceIF testTypeService;

    @Autowired
    QuestionServiceIF questionSerivce;

    @GetMapping(value = "/list")
    public String listTest(@RequestParam(required = false) Integer page, Model model) {
        List<Test> tests = testService.getTests();
        PagedListHolder<Test> pagedListHolderTest = new PagedListHolder<Test>(tests);
        pagedListHolderTest.setPageSize(5);
        model.addAttribute("maxPages", pagedListHolderTest.getPageCount());

        if (page == null || page < 1 || page > pagedListHolderTest.getPageCount()) {
            page = 1;
        }
        model.addAttribute("page", page);
        if (page == null || page < 1 || page > pagedListHolderTest.getPageCount()) {
            pagedListHolderTest.setPage(0);
            model.addAttribute("tests", pagedListHolderTest.getPageList());
        } else if (page <= pagedListHolderTest.getPageCount()) {
            pagedListHolderTest.setPage(page - 1);
            model.addAttribute("tests", pagedListHolderTest.getPageList());
        }

        return "list-test";
    }

    @GetMapping(value = "/createTestForm")
    public String showFormForAdd(Model model) {
        TestModel testModel = new TestModel();
        model.addAttribute("testModel", testModel);
        List<TestType> listTestType = testTypeService.getTestTypes();
        model.addAttribute("testType", listTestType);
        return "create-test";
    }

    @PostMapping(value = "/saveTest")
    public String saveTest(@ModelAttribute("testModel") TestModel testModel) {

        TestType test_type = testTypeService.getTestType(testModel.getTest_type_id());

        Test test = testService.getTest(testModel.getTest_id());
        if (test != null) {
            test.setTest_name(testModel.getTest_name());
            test.setDescription(testModel.getDescription());
            test.setTest_time(testModel.getTest_time());
            test.setPassword(testModel.getPassword());
            test.setTest_type(test_type);
            test.setQuestion_number(testModel.getQuestion_number());
            testService.saveTest(test);
        } else {
            test = new Test();
            test.setTest_name(testModel.getTest_name());
            test.setDescription(testModel.getDescription());
            test.setTest_time(testModel.getTest_time());
            test.setPassword(testModel.getPassword());
            test.setTest_type(test_type);
            test.setQuestion_number(testModel.getQuestion_number());
            testService.saveTest(test);
            
        }

        return "redirect:/test/list";
    }

    @GetMapping(value = "/updateTestForm")
    public String showFormForUpdate(@RequestParam("testId") int id, Model model) {
        Test test = testService.getTest(id);
        TestModel testModel = new TestModel();
        testModel.setTest_name(test.getTest_name());
        testModel.setDescription(test.getDescription());
        testModel.setTest_time(test.getTest_time());
        testModel.setPassword(test.getPassword());
        testModel.setTest_type_id(test.getTest_type().getTest_type_id());
        testModel.setQuestion_number(test.getQuestion_number());
        model.addAttribute("testModel", testModel);
        List<TestType> listTestType = testTypeService.getTestTypes();
        model.addAttribute("testType", listTestType);
        model.addAttribute("test_id", id);
        return "create-test";
    }

    @GetMapping(value = "/deleteTest")
    public String deleteTest(@RequestParam("testId") int id) {
        testService.deleteTest(id);
        return "redirect:/test/list";
    }

    @GetMapping(value = "/InputQuestion")
    public String inputQuestion(@RequestParam("testId") int id, Model model) {
        List<Question> listQuestionCheck = testService.getTest(id).getListQuestion();
        model.addAttribute("listQuestionCheck", listQuestionCheck);
        List<Question> listQuestion = questionSerivce.getQuestions();
        List<Question> listQuestionUncheck = new ArrayList<Question>();

        for (Question question : listQuestion) {
            if (questionSerivce.isExist(question, listQuestionCheck) == false) {
                listQuestionUncheck.add(question);
            }
        }

        model.addAttribute("listQuestionUncheck", listQuestionUncheck);
        TestModel testModel = new TestModel();
        String testName = testService.getTest(id).getTest_name();
        model.addAttribute("testModel", testModel);
        model.addAttribute("test_id", id);
        model.addAttribute("testName", testName);

        return "input-question";
    }

    @PostMapping(value = "/saveListQuestion")
    public String saveListQuestion(@ModelAttribute("testModel") TestModel testModel) {
        List<Question> listQuestion = new ArrayList<Question>();
        for (int question_id : testModel.getList_question_id()) {
            listQuestion.add(questionSerivce.getQuestion(question_id));
        }
        Test test = testService.getTest(testModel.getTest_id());
        test.setListQuestion(listQuestion);

        testService.saveTest(test);

        return "redirect:/test/list";
    }
}
