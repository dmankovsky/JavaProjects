package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CredentialMapper {

    //addCredential
    @Insert("insert into credentials (credentialid, url, username, key, password, userid)" +
            ("values(#{credentialid}, #{url}, #{username}, #{key}, #{password}, #{userid})"))
    @Options(useGeneratedKeys = true, keyProperty = "credentialid")
    int addCredential(Credential credential);

    //editCredential
    @Update("update credentials set url=#{url}, username=#{username}, " +
    "key=#{key}, password=#{password} where credentialid=#{credentialid}")
    int editCredential(Credential credential);

    //deleteCredential
    @Delete("delete from credentials where credentialid=#{credentialid}")
    int deleteCredential(Integer credentialid);

    //isOnlyUsername
    @Select("select * from credentials where userid=#{userid} and username=#{username}")
    Credential isOnlyUsername(Integer userid, String username);

    //getFromUserId
    @Select("select * from credentials where userid=#{userid}")
    List<Credential> getFromUserId(int userid);
}
