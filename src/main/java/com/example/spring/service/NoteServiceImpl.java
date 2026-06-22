package com.example.spring.service;

import com.example.spring.entity.Note;
import com.example.spring.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    @Autowired
    private final NoteRepository noteRepository;


    @Override
    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note add(Note note) {
        noteRepository.save(note);
        return note;
    }

    @Override
    public void deleteById(Long id) {
        if(noteRepository.existsById(id)){
            noteRepository.deleteById(id);
        } else throw new RuntimeException("Note not found");
    }

    @Override
    public void update(Note note) {
        if(noteRepository.existsById(note.getId())){
            noteRepository.save(note);
        } else throw new RuntimeException("Note with id " + note.getId() + " not found");
    }

    @Override
    public Note getById(Long id) {
        return noteRepository.findById(id).orElseThrow(() -> new RuntimeException("can`t find id"));
    }
}
