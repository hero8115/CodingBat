package com.example.codingbat.controller;

import com.example.codingbat.dto.AnswerDto;
import com.example.codingbat.dto.ApiResponse;
import com.example.codingbat.entity.Answer;
import com.example.codingbat.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @GetMapping
    public List<Answer> answerList(){
        return answerService.answerList();
    }

    @PostMapping
    public ApiResponse addAnswer(@RequestBody AnswerDto answerDto){
        return answerService.addAnswer(answerDto);
    }

}
