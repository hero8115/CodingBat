package com.example.codingbat.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnswerDto {

    @NotNull(message = "Javobsiz bo'lishi mumkin emas")
    private String field;

    @NotNull(message = "Masalaning Id si kiritilishi shart")
    private Integer task_id;
}
