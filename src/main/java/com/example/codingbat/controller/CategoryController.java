package com.example.codingbat.controller;

import com.example.codingbat.dto.ApiResponse;
import com.example.codingbat.dto.CategoryDto;
import com.example.codingbat.entity.Category;
import com.example.codingbat.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> categoryList(){
        return categoryService.categoryList();
    }

    @PostMapping
    public ApiResponse addCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.addCategory(categoryDto);
    }

    @PutMapping("/{id}")
    public ApiResponse updateCategory(@PathVariable Integer id, @RequestBody CategoryDto categoryDto){
        return categoryService.updateCategory(id,categoryDto);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteCategory(@PathVariable Integer id){
        return categoryService.deleteCategory(id);
    }

}
