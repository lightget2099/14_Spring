package com.example.spring.controller;

import com.example.spring.dto.NoteRequestDto;
import com.example.spring.dto.NoteResponseDto;
import com.example.spring.entity.Note;
import com.example.spring.mapper.NoteMapper;
import com.example.spring.service.NoteServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {

    private final NoteServiceImpl noteService;
    private final NoteMapper noteMapper;

    @PostMapping("/create")
    public NoteResponseDto createNote(@Valid @RequestBody NoteRequestDto dto) {
       Note note = noteMapper.toEntity(dto);
       Note savedNote = noteService.add(note);
       return noteMapper.toDto(savedNote);
    }

    @GetMapping("/list")
    public List<NoteResponseDto> listAll() {
        return noteService.listAll().stream().map(noteMapper::toDto).toList();
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable("id") Long id) {
        noteService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void editV2(@Valid @RequestBody NoteRequestDto noteRequestDto, @PathVariable("id") Long id) {
        Note note = noteMapper.toEntity(noteRequestDto);
        note.setId(id);
        noteService.update(note);
    }

    @GetMapping("/{id}")
    public NoteResponseDto getNoteById(@PathVariable("id") Long id) {
        Note note = noteService.getById(id);
        return noteMapper.toDto(note);
    }

}
