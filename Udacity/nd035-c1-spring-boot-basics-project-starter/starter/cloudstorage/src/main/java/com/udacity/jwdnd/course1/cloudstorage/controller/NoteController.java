package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.NoteOverviewForm;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/note")
public class NoteController {
    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public String getNotePage(NoteOverviewForm noteOverviewForm, Model model){
        model.addAttribute("newNote", noteOverviewForm);
        model.addAttribute("allNotes",this.noteService.getAllNotes());
        return "home/#nav-notes";
    }

    @PostMapping
    public String postNewNote(Authentication authentication, NoteOverviewForm noteOverviewForm, Model model){
        noteOverviewForm.setUserName(authentication.getName());
        this.noteService.addNote(noteOverviewForm);
        noteOverviewForm.setNoteTitle("");
        noteOverviewForm.setNoteDescription("");
        model.addAttribute("noteOverviewForm", this.noteService.getAllNotes());
        return "/home";
    }
}
