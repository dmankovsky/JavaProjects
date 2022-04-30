package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.SingleNote;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/note")
public class NoteController {
    private final UserService userService;
    private final NoteService noteService;

    @Autowired
    public NoteController(UserService userService, NoteService noteService) {
        this.userService = userService;
        this.noteService = noteService;
    }

    @PostMapping("/addnote")
    public String addOrEditNote(@ModelAttribute SingleNote note, Model model, Authentication authentication) {
        int userFromId = userService.getUserId(authentication.getName());
        Optional<Integer> noteId = Optional.ofNullable(note.getNoteid());
        if (noteId.isEmpty()) {
            return addNote(note, model, userFromId);
        } else return editNote(note, model, userFromId);
    }

    private String addNote(SingleNote note, Model model, int userFromId){
        if(noteService.isOnlyNote(userFromId, note.getNotetitle(), note.getNotedescription())){
            return displayResult(model, noteService.addNote(note, userFromId));
        } else{
            return displayOtherErrorMsg( "Note already exists", model);
        }
    }

    private String editNote(SingleNote note, Model model, int userFromId){
        if(noteService.isOnlyNote(userFromId, note.getNotetitle(), note.getNotedescription())){
            return displayResult(model, noteService.editNote(note));
        } else{
            return displayOtherErrorMsg( "Note already exists", model);
        }
    }

    private String displayOtherErrorMsg(String msg, Model model){
        model.addAttribute("otherErrorMsg", true);
        return "result";
    }

    @GetMapping("/deleteNote/{noteId:.+}")
    public String deleteNote(@PathVariable Integer noteId, Model model){
        return displayResult(model, noteService.deleteNote(noteId));
    }

    private String displayResult(Model model, int entry){
        if(entry==1){
            model.addAttribute("successMsg", true);
        } else{
            model.addAttribute("notSavedErrorMsg", true);
        }
        return "result";
    }

}