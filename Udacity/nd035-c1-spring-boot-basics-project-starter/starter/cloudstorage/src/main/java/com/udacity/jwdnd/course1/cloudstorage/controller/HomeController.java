package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.NoteOverviewForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    //TODO check https://knowledge.udacity.com/questions/783782 and add respective methods
    @ModelAttribute("newNote")
    public NoteOverviewForm getNoteForm(){
        return new NoteOverviewForm();
    }

    @GetMapping
    public String homeView(Model model){
        return "home";
    }

}
