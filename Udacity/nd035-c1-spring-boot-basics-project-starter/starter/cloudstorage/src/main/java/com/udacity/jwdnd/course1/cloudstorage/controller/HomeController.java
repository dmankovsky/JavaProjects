package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.SingleNote;
import com.udacity.jwdnd.course1.cloudstorage.services.EncryptionService;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
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
    private final EncryptionService encryptionService;

    public HomeController(UserService userService, NoteService noteService, EncryptionService encryptionService) {
        this.userService = userService;
        this.noteService = noteService;
        this.encryptionService = encryptionService;
    }

    List<SingleNote>notes;

    //TODO check https://knowledge.udacity.com/questions/783782 and add respective methods
    //TODO modify the rest of home controller - key to everything

    @PostConstruct
    public void postConstruct(){
        notes = new ArrayList<>();
    }

    @GetMapping
    public String homeView(Model model, Authentication authentication){
        Integer userId = userService.getUserId(authentication.getName());
        notes = noteService.getAllNotesForUser(userId);

        model.addAttribute("note", new SingleNote());
        model.addAttribute("notes", notes);

        model.addAttribute("encryptionService", encryptionService);

        return "home";
    }

}
