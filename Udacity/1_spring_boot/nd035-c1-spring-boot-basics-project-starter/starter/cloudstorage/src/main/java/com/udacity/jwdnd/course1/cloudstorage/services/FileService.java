package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@Service
public class FileService {

    private final FileMapper fileMapper;

    @Autowired
    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    public int addFile(MultipartFile multipartFile, int userId) throws IOException{
        return fileMapper.addFile(new File
                (null, multipartFile.getOriginalFilename(), multipartFile.getContentType(),
                        Long.toString(multipartFile.getSize()),
                        userId, multipartFile.getBytes()));
    }

    public File getFileByFileId(int fileId){
        return fileMapper.getFileByFileId(fileId);
    }

    public int deleteFile(int fileId){
        return fileMapper.deleteFile(fileId);
    }

    public boolean isOnlyFileName(Integer userId, String fileName){
        Optional<File>file = Optional.ofNullable(fileMapper.isOnlyFileName(userId,fileName));
        return(file.isEmpty());
    }

    public List<File> getFilesFromUserId(int userId){
        return fileMapper.getFilesFromUserId(userId);
    }

}
