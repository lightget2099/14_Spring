package com.example.spring.service;

import com.example.spring.entity.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteServiceImpl implements NoteService {
    //щось по типу БД, наше фейкове сховище
    private Map<Long, Note> notes = new HashMap<>();
    private long noteIdCounter = 1;

    @Override
    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    @Override
    public Note add(Note note) {
        note.setId(noteIdCounter);
        noteIdCounter++;
        notes.put(note.getId(), note);
        return note;
    }

    @Override
    public void deleteById(long id) {
        if (notes.containsKey(id)) {
            notes.remove(id);
        } else throw new RuntimeException("Note with id " + id + " not found");
    }

    @Override
    public void update(Note note) {
        if (notes.containsKey(note.getId())) {
            notes.put(note.getId(), note);
        } else throw new RuntimeException("Note with id " + note.getId() + " not found");
    }

    @Override
    public Note getById(long id) {
        if (notes.containsKey(id)) {
            return notes.get(id);
        } else throw new RuntimeException("Note with id " + id + " not found");
    }
}
