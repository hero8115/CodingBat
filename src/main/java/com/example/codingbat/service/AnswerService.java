package com.example.codingbat.service;

import com.example.codingbat.dto.AnswerDto;
import com.example.codingbat.dto.ApiResponse;
import com.example.codingbat.entity.Answer;
import com.example.codingbat.entity.Task;
import com.example.codingbat.repository.AnswerRepository;
import com.example.codingbat.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    TaskRepository taskRepository;

    public List<Answer> answerList(){
        return answerRepository.findAll();
    }

    public ApiResponse addAnswer(AnswerDto answerDto) {
        Optional<Task> byId = taskRepository.findById(answerDto.getTask_id());
        if (byId.isPresent()) {
            Answer answer = new Answer();
            answer.setField(answerDto.getField());
            answer.setTask(byId.get());
            answerRepository.save(answer);
            return new ApiResponse("Javob saqlandi", true);
        }
        return new ApiResponse("Bunday Id lik masala topilmadi", false);
    }


}
