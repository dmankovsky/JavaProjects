package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
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
    private final EncryptionService encryptionService;
    private final CredentialService credentialService;

    public HomeController(UserService userService, NoteService noteService, EncryptionService encryptionService, CredentialService credentialService) {
        this.userService = userService;
        this.noteService = noteService;
        this.encryptionService = encryptionService;
        this.credentialService = credentialService;
    }

    List<SingleNote>notes;
    List<Credential>credentials;
    List<String>decryptedPasswords;

    //TODO check https://knowledge.udacity.com/questions/783782 and add respective methods
    //TODO modify the rest of home controller - key to everything

    @PostConstruct
    public void postConstruct(){
        notes = new ArrayList<>();
        credentials = new ArrayList<>();
        decryptedPasswords = new ArrayList<>();
    }

    @GetMapping
    public String homeView(Model model, Authentication authentication){
        Integer userFromId = userService.getUserId(authentication.getName());
        notes = noteService.getAllNotesForUser(userFromId);
        credentials = credentialService.getCredentialFromUserId(userFromId);
        decryptedPasswords = credentialService.getDecryptedPasswordsFromUserId(userFromId);

        model.addAttribute("note", new SingleNote());
        model.addAttribute("notes", notes);
        model.addAttribute("credential" , new Credential());
        model.addAttribute("credentials" , credentials);
        model.addAttribute("credentialService", credentialService);
        model.addAttribute("encryptionService", encryptionService);

        return "home";
    }

}
