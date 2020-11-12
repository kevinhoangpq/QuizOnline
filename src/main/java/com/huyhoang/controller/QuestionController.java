/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huyhoang.controller;

import com.huyhoang.entity.Question;
import com.huyhoang.service.QuestionServiceIF;
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
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionServiceIF questionService;

    @GetMapping(value = "/list")
    public String listQuestion(@RequestParam(required = false) Integer page, Model model) {
        List<Question> questions = questionService.getQuestions();
        PagedListHolder pagedListHolderQuestion = new PagedListHolder<>(questions);
        pagedListHolderQuestion.setPageSize(5);
        model.addAttribute("maxPages", pagedListHolderQuestion.getPageCount());

        if (page == null || page < 1 || page > pagedListHolderQuestion.getPageCount()) {
            page = 1;
        }
        model.addAttribute("page", page);
        if (page == null || page < 1 || page > pagedListHolderQuestion.getPageCount()) {
            pagedListHolderQuestion.setPage(0);
            model.addAttribute("questions", pagedListHolderQuestion.getPageList());
        } else if (page <= pagedListHolderQuestion.getPageCount()) {
            pagedListHolderQuestion.setPage(page - 1);
            model.addAttribute("questions", pagedListHolderQuestion.getPageList());
        }

        return "list-question";
    }

    @GetMapping(value = "/createQuestionForm")
    public String showFormForAdd(Model model) {
        Question question = new Question();
        model.addAttribute("question", question);
        return "create-question";
    }

    @PostMapping(value = "/saveQuestion")
    public String saveQuestion(@ModelAttribute("question") Question question, Model model) {

        questionService.saveQuestion(question);
        return "redirect:/question/list";

    }

    @GetMapping(value = "/updateQuestionForm")
    public String showFormForUpdate(@RequestParam("questionId") int id, Model model) {
        Question question = questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "create-question";
    }

    @GetMapping(value = "/deleteQuestion")
    public String deleteQuestion(@RequestParam("questionId") int id) {
        questionService.deleteQuestion(id);
        return "redirect:/question/list";
    }
}
