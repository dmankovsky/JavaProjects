package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/credential")
public class CredentialController {

    private final UserService userService;
    private final CredentialService credentialService;

    public CredentialController(UserService userService, CredentialService credentialService) {
        this.userService = userService;
        this.credentialService = credentialService;
    }

    // add or edit credential 2x
    @PostMapping("/addcredential")
    public String addOrEditCredential(@ModelAttribute Credential credential, Model model, Authentication authentication){
        int userFromId = userService.getUserId(authentication.getName());
        Optional<Integer> credentialId = Optional.ofNullable(credential.getCredentialId());
        if (credentialId.isEmpty()){
            return addCredential(credential, model, userFromId);
        } else {
            return editCredential (credential, model, userFromId);
        }
    }

    private String addCredential (Credential credential, Model model, int userFromId){
        if (credentialService.isOnlyUsername(userFromId, credential.getUsername())){
            credential.setUserId(userFromId);
            return displayResult(model, credentialService.addCredential(credential));
        } else {
            return displayOtherErrorMsg("User already exists", model);
        }
    }

    private String editCredential(Credential credential, Model model, int userFromId){
        if(credentialService.isOnlyUsername(userFromId, credential.getUsername())){
            return displayResult(model, credentialService.editCredential(credential));
        } else {
            return displayOtherErrorMsg("User already exists.", model);
        }
    }

    private String displayResult(Model model, int entry){
        if (entry == 1){
            model.addAttribute("successMsg",true);
        } else {
            model.addAttribute("notSavedErrorMsg", true);
        }
        return "result";
    }

    private String displayOtherErrorMsg(String msg, Model model){
        model.addAttribute("otherErrorMsg", msg);
        return "result";
    }

    @GetMapping("/deletecredential/{credentialId:.+}")
    public String deleteCredential(@PathVariable Integer credentialId, Model model){
        return displayResult(model, credentialService.deleteCredential(credentialId));
    }

}
