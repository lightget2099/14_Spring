package com.example.spring.dto;

import lombok.Value;

@Value
public class NoteResponseDto {
    Long id;

    String title;

    String content;

}
