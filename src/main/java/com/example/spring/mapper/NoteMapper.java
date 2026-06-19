package com.example.spring.mapper;

import com.example.spring.dto.NoteRequestDto;
import com.example.spring.dto.NoteResponseDto;
import com.example.spring.entity.Note;
import org.springframework.stereotype.Component;

@Component
public class NoteMapper {

    public NoteResponseDto toDto(Note note) {
        NoteResponseDto noteResponseDto = new NoteResponseDto();
        noteResponseDto.setId(note.getId());
        noteResponseDto.setTitle(note.getTitle());
        noteResponseDto.setContent(note.getContent());
        return noteResponseDto;
    }

    public Note toEntity(NoteRequestDto noteRequestDto) {
        Note note = new Note();
        note.setTitle(noteRequestDto.getTitle());
        note.setContent(noteRequestDto.getContent());
        return note;
    }
}
