package com.example.codingbat.controller;

import com.example.codingbat.dto.ApiResponse;
import com.example.codingbat.dto.TaskDto;
import com.example.codingbat.entity.Task;
import com.example.codingbat.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping
    public List<Task> taskList(){
        return taskService.taskList();
    }

    @PostMapping
    public ApiResponse addTask(@RequestBody TaskDto taskDto){
        return taskService.addTask(taskDto);
    }

}
