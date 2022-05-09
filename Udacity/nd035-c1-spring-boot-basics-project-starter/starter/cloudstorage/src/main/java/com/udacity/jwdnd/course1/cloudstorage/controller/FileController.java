package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileController {

    private final UserService userService;
    private final FileService fileService;

    @Autowired
    public FileController(UserService userService, FileService fileService) {
        this.userService = userService;
        this.fileService = fileService;
    }

    @PostMapping("/uploadfile")
    public String uploadFile(@RequestParam("fileUpload") MultipartFile multipartFile,
                             Authentication authentication, Model model) throws IOException {
        int userId = userService.getUserId(authentication.getName());
        if(!multipartFile.isEmpty()){
            if(fileService.isOnlyFileName(userId, multipartFile.getOriginalFilename())){
                return displayResult(model, fileService.addFile(multipartFile, userId));
            } else{
                return displayFileErrorMsg( "That file name already exists", model);
            }
        }else {
            return displayFileErrorMsg( "Error. Select file to upload first", model);
        }
    }

    @GetMapping("/viewfile/{fileId:.+}")
    public ResponseEntity<Resource> viewFile(@PathVariable int fileId){
        File file = fileService.getFileByFileId(fileId);
        InputStream inputStream = new ByteArrayInputStream(file.getFileData());
        InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"fileName"+file.getFileName()).
                contentType(MediaType.parseMediaType(file.getContentType())).body(inputStreamResource);
    }
    
    @GetMapping("deletefile/{fileId:.+}")
    public String deleteFile(@PathVariable Integer fileId, Model model){
        return displayResult(model, fileService.deleteFile(fileId));
    }

    private String displayResult(Model model, int entry){
        if (entry == 1){
            model.addAttribute("successMsg", true);
        } else {
            model.addAttribute("notSavedErrorMsg", true);
        }
        return "return";
    }

    private String displayFileErrorMsg(String msg, Model model){
        model.addAttribute("fileErrorMsg", true);
        model.addAttribute("fileErrorMsgText", msg);
        return "result";
    }

    private String displayOtherErrorMsg(String msg, Model model){
        model.addAttribute("otherErrorMsg", true);
        return "result";
    }

}
