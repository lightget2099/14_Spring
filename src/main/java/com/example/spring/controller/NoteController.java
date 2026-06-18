package com.example.spring.controller;

import com.example.spring.entity.Note;
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

    @PostMapping("/create")
    public Note createNote(@Valid @RequestBody Note note) {
        return noteService.add(note);
    }

    @GetMapping("/list")
    public List<Note> listAll() {
      return  noteService.listAll();
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable("id") Long id) {
        noteService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void editV2(@Valid @RequestBody Note note, @PathVariable("id") Long id) {
        note.setId(id);
        noteService.update(note);
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable("id") Long id) {
        return noteService.getById(id);
    }

}
