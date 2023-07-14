package com.example.codingbat.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountDto {

    @NotNull(message ="email bo'sh bo'lishi mumkin emas")
    @Email(message = "@ belgisi bo'lishi shart")
    private String email;

    @NotNull(message ="password bo'sh bo'lishi mumkin emas")
    @Min(message = "min 8 ta raqam qatnashishi kerak", value = 8)
    @NotBlank(message = "kamida 1ta belgi bo'lishi kerak")
    private String password;
}
