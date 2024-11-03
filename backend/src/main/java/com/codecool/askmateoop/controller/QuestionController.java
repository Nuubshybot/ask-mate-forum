package com.codecool.askmateoop.controller;

import com.codecool.askmateoop.controller.dto.questionDTO.EditQuestionDTO;
import com.codecool.askmateoop.controller.dto.questionDTO.NewQuestionDTO;
import com.codecool.askmateoop.controller.dto.questionDTO.QuestionDTO;
import com.codecool.askmateoop.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/question")
public class QuestionController {
    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/all")
    public List<QuestionDTO> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public QuestionDTO getQuestionById(@PathVariable int id) {
        return questionService.getQuestionById(id);
    }

    @PostMapping("/add")
    public int addNewQuestion(@RequestBody NewQuestionDTO question) {
        return questionService.addNewQuestion(question);
    }

    @DeleteMapping("/{id}")
    public boolean deleteQuestionById(@PathVariable int id) {
       return questionService.deleteQuestionById(id);
    }

    @PatchMapping("/{id}")
    public int updateQuestionById(@PathVariable int id, @RequestBody EditQuestionDTO question ) {
        return questionService.updateQuestion(id,question);
    }



}
