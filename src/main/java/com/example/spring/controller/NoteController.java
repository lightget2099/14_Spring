package com.example.spring.controller;

import com.example.spring.entity.Note;
import com.example.spring.service.NoteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {

    private final NoteServiceImpl noteService;

    @PostMapping("/create")
    public ModelAndView createNote(@RequestParam("title") String title,
                                   @RequestParam("content") String content) {
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        noteService.add(note);
        return new ModelAndView("redirect:/note/list");
    }

    @GetMapping("/list")
    public ModelAndView listAll() {
        List<Note> notes = noteService.listAll();
        ModelAndView modelAndView = new ModelAndView("note/list");
        modelAndView.addObject("notes", notes);
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView deleteNote(@RequestParam("id") Long id) {
        noteService.deleteById(id);
        return new ModelAndView("redirect:/note/list");
    }

    @GetMapping("/edit")
    public ModelAndView editNote(@RequestParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("note/edit");
        modelAndView.addObject("note", noteService.getById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editV2(@RequestParam("id") Long id,
                               @RequestParam("content") String content,
                               @RequestParam("title") String title
                               ) {
        Note note = new Note();
        note.setId(id);
        note.setContent(content);
        note.setTitle(title);
        noteService.update(note);
        return new ModelAndView("redirect:/note/list");
    }
}
