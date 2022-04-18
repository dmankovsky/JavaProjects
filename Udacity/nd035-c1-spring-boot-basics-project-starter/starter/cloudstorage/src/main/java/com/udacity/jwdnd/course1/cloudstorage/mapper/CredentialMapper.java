package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface CredentialMapper {
    //addCredential

    @Insert("insert into credentials (credentialid, url, username, key, password, userid)" +
            ("values(#{credentialid}, #{url}, #{username}, #{key}, #{password}, #{userid})"))
    @Options(useGeneratedKeys = true, keyProperty = "credentialid")
    int addCredential(Credential credential);

    //editCredential
    //deleteCredential
    //isOnlyUsername
    //getFromUserId
}
