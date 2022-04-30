package com.udacity.jwdnd.course1.cloudstorage.Mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USERS WHERE username = #{username}")
    User getUser(String username);
    @Select("SELECT userid FROM USERS WHERE username = #{username}")
    Integer getUserId(String username);
    @Insert("INSERT INTO USERS (username, salt, password, firstName, lastName) " +
            "VALUES(#{username}, #{salt}, #{password}, #{firstName}, #{lastName})")
    @Options(useGeneratedKeys = true, keyProperty = "userid")
    int insert(User user);
}