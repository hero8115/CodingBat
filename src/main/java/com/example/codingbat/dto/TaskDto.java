package com.example.codingbat.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDto {

    @NotNull(message = "Nomsiz bo'lishi mumkin emas")
    private String name;

    @NotNull(message = "Sharti berilishi shart")
    private String description;

    private String example;

    private boolean isTrue;

    private Integer category_id;
}
