package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.SingleNote;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {
    @Select("select * from notes where userId = #{userId}")
    List<SingleNote> getAllNotesForUser(Integer userId); // add this method in NoteService

    @Insert("insert into notes (noteTitle, noteDescription, userId) values (#{noteTitle}, #{noteDescription}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    int addNote(SingleNote singleNote); // add this method in NoteService

    @Update("update notes set noteText = #{noteDescription} where noteId = #{noteId}")
    int editNote(SingleNote singleNote); // add this method in NoteService

    @Select("select * from notes where userId=#{userId} and noteTitle=#{noteTitle} and noteDescription=#{noteDescription}")
    SingleNote isOnlyNote(Integer userId, String noteTitle, String noteDescription);

    @Delete("delete from notes where noteId = #{noteId}")
    int deleteNote(Integer noteId);
}
