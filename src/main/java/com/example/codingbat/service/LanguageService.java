package com.example.codingbat.service;

import com.example.codingbat.dto.ApiResponse;
import com.example.codingbat.dto.LanguageDto;
import com.example.codingbat.entity.Language;
import com.example.codingbat.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    @Autowired
    LanguageRepository languageRepository;

    public List<Language> languageList(){
        return languageRepository.findAll();
    }

    public ApiResponse addLanguage(LanguageDto languageDto){
        boolean existsByName = languageRepository.existsByName(languageDto.getName());
        if (existsByName){
            return new ApiResponse("Bunday til mavjud bo'lishi mumkin", false);
        }
        Language language = new Language();
        language.setName(languageDto.getName());
        languageRepository.save(language);
        return new ApiResponse("Til qo'shildi", true);
    }





}
