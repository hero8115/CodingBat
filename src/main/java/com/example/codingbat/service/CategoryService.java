package com.example.codingbat.service;

import com.example.codingbat.dto.ApiResponse;
import com.example.codingbat.dto.CategoryDto;
import com.example.codingbat.entity.Category;
import com.example.codingbat.entity.Language;
import com.example.codingbat.repository.CategoryRepository;
import com.example.codingbat.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    LanguageRepository languageRepository;

    public List<Category> categoryList(){
        return categoryRepository.findAll();
    }

    public ApiResponse addCategory(CategoryDto categoryDto) {
        boolean existsByName = categoryRepository.existsByName(categoryDto.getName());
        Optional<Language> byId = languageRepository.findById(categoryDto.getLanguage_id());
        if (existsByName) {
            return new ApiResponse("Bunday nomli categoriya mavjud bo'lishi mumkin", false);
        }
        if (byId.isPresent()) {
            Category category = new Category();
            category.setName(categoryDto.getName());
            category.setStar(categoryDto.getStar());
            category.setDescription(categoryDto.getDescription());
            category.setTrue(categoryDto.isTrue());
            category.setLanguage(byId.get());
            categoryRepository.save(category);
            return new ApiResponse("Categoriya qo'shildi", true);
        }
        return new ApiResponse("Bunday Id lik til topilmadi", false);
    }

    public ApiResponse updateCategory(Integer id, CategoryDto categoryDto){
        Optional<Category> byId = categoryRepository.findById(id);
        boolean b = categoryRepository.existsByName(categoryDto.getName());
        if (byId.isPresent() && !b){
            Category category = byId.get();
            category.setName(category.getName());
            category.setStar(categoryDto.getStar());
            category.setDescription(categoryDto.getDescription());
            category.setTrue(categoryDto.isTrue());
            categoryRepository.save(category);
            return new ApiResponse("Malumotlar yangilandi", true);
        }
        return new ApiResponse("Bunday Id lik categoriya topilmadi", false);
    }

    public ApiResponse deleteCategory(Integer id){
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isPresent()){
            categoryRepository.deleteById(id);
            return new ApiResponse("Categoriya o'chirildi", true);
        }
        return new ApiResponse("Bunday Id lik categoriya topilmadi", false);
    }


}
