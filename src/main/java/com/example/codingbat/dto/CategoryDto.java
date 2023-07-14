package com.example.codingbat.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDto {
   @NotNull(message ="name bo'sh bo'lishi mumkin emas")
    private String name;

   @NotNull(message ="yulduz bo'sh bo'lishi mumkin emas")
    private Integer star;

   @NotNull(message ="description bo'sh bo'lishi mumkin emas")
    private String description;

    private boolean isTrue;

    @NotNull(message = "qaysi tilga tegishligini kiritish kerak")
    private Integer language_id;

}
