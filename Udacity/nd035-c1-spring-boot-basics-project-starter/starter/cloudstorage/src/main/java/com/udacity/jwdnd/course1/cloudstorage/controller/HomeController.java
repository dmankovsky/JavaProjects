package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.SingleNote;
import com.udacity.jwdnd.course1.cloudstorage.services.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final UserService userService;
    private final NoteService noteService;


    public HomeController(UserService userService,
                          NoteService noteService
                          ) {
        this.userService = userService;
        this.noteService = noteService;
    }

    List<SingleNote>notes;
    List<File>files;

    @PostConstruct
    public void postConstruct(){
        notes = new ArrayList<>();

    }

    @GetMapping
    public String getHome(Model model, Authentication authentication){
        Integer userFromId = userService.getUserFromId(authentication.getName());
        notes = noteService.getNotesFromUserId(userFromId);

        model.addAttribute("note", new SingleNote());
        model.addAttribute("notes", notes);

        return "home";
    }
}