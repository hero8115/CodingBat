package com.example.codingbat.service;

import com.example.codingbat.dto.ApiResponse;
import com.example.codingbat.dto.TaskDto;
import com.example.codingbat.entity.Category;
import com.example.codingbat.entity.Task;
import com.example.codingbat.repository.CategoryRepository;
import com.example.codingbat.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<Task> taskList(){
        return taskRepository.findAll();
    }

    public ApiResponse addTask(TaskDto taskDto){
        boolean b = taskRepository.existsByName(taskDto.getName());
        Optional<Category> byId = categoryRepository.findById(taskDto.getCategory_id());
        if (!b && byId.isPresent()){
            Task task = new Task();
            task.setName(taskDto.getName());
            task.setDescription(taskDto.getExample());
            task.setExample(taskDto.getExample());
            task.setTrue(taskDto.isTrue());
            task.setCategory(byId.get());
            taskRepository.save(task);
            return new ApiResponse("Masala saqlandi", true);
        }
        return new ApiResponse("Bunday nomli masala bo'lishi mumkin", false);
    }

}
