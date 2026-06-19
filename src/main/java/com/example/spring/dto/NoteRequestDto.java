package com.example.spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NoteRequestDto {
    @NotBlank
    @Size(min = 3, max = 100)
    private String title;

    @NotBlank
    private String content;
}
