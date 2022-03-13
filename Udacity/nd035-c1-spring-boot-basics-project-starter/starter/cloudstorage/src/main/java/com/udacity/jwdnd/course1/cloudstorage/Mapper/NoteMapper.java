package com.udacity.jwdnd.course1.cloudstorage.Mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.SingleNote;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {
    @Select("select * from notes")
    List<SingleNote> getAllNotes(); // add this method in NoteService

    @Insert("insert into notes (username, noteText) values (#{username},#{noteText})")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    int addNote(SingleNote singleNote); // add this method in NoteService

    @Update("update notes set noteText = #{noteText} where noteId = #{noteId}")
    int updateNote(SingleNote singleNote); // add this method in NoteService
}
