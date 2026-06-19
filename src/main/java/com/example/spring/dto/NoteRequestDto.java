package com.example.spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Value;

@Value
public class NoteRequestDto {
    @NotBlank
    @Size(min = 3, max = 100)
    String title;

    @NotBlank
    String content;
}
