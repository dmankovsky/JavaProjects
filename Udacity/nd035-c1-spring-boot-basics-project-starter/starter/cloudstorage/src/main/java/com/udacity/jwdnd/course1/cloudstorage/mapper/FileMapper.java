package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.apache.ibatis.annotations.*;

import java.util.List;
// TODO: complete section. appears complete
public interface FileMapper {
    // add file
    @Insert("insert into files (fileId, fileName, contentType, fileSize, userId, fileData)" +
            ("values(#{fileId}, #{fileName}, #{contentType}, #{fileSize}, #{userId}, #{fileData})"))
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    int addFile(File file);

    // delete file
    @Delete("delete from files where fileId=#{fileid}")
    int deleteFile(Integer fileid);

    // is the only file
    @Select("select * from files where filename=#{filename} and userid=#{userid}")
    File isOnlyFileName(Integer userid, String filename);

    // getFromUserId
    @Select("select * from files where userid=#{userid}")
    List<File> getFilesFromUserId(int userid);

    // get by file id
    @Select("select * from files where fileId=#{fileid}")
    File getFileByFileId(int fileid);
}
