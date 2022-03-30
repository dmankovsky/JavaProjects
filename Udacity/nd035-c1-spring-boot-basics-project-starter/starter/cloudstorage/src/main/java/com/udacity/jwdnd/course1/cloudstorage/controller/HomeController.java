package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.NoteOverviewForm;
import com.udacity.jwdnd.course1.cloudstorage.model.SingleNote;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    //make equivalent to chat in review project
    // check the template. many functions and buttons there

    //TODO check https://knowledge.udacity.com/questions/783782 and add respective methods
    @ModelAttribute("newNote")
    public NoteForm getNoteForm(){
        return new SingleNote();
    }


}
