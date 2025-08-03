package com.ankitkr5447.gmail.LearningRestApi.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestStudentDto {
    private long id;

    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 2, max = 100, message = "Name is not between 2 to 100 ")
    private String name;
}

