package com.example.codingbat.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LanguageDto {

    @NotNull(message = "Tilni kiritishingiz shart")
    private String name;


}
