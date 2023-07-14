package com.example.codingbat.controller;

import com.example.codingbat.dto.ApiResponse;
import com.example.codingbat.dto.LanguageDto;
import com.example.codingbat.entity.Language;
import com.example.codingbat.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    LanguageService languageService;

    @GetMapping
    public List<Language> languageList(){
        return languageService.languageList();
    }

    @PostMapping
    public ApiResponse addLanguage(@RequestBody LanguageDto languageDto){
        return languageService.addLanguage(languageDto);
    }







}
