package com.example.spring.mapper;

import com.example.spring.dto.NoteRequestDto;
import com.example.spring.dto.NoteResponseDto;
import com.example.spring.entity.Note;
import org.springframework.stereotype.Component;

@Component
public class NoteMapper {

    public NoteResponseDto toDto(Note note) {
      return new NoteResponseDto(note.getId(), note.getTitle(), note.getContent());
    }

    public Note toEntity(NoteRequestDto noteRequestDto) {
        Note note = new Note();
        note.setTitle(noteRequestDto.getTitle());
        note.setContent(noteRequestDto.getContent());
        return note;
    }
}
