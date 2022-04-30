package com.udacity.jwdnd.course1.cloudstorage.Mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.SingleNote;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {
    @Select("select * from notes where userid = #{userid}")
    List<SingleNote> getAllNotesForUser(Integer userid); // add this method in NoteService

    @Insert("insert into notes (notetitle, notedescription, userid) values (#{notetitle}, #{notedescription}, #{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "noteid")
    int addNote(SingleNote singleNote); // add this method in NoteService

    @Update("update notes set notedescription = #{notedescription} where noteid = #{noteid}")
    int editNote(SingleNote singleNote); // add this method in NoteService

    @Select("select * from notes where userid=#{userid} and notetitle=#{notetitle} and notedescription=#{notedescription}")
    SingleNote isOnlyNote(Integer userid, String notetitle, String notedescription);

    @Delete("delete from notes where noteid = #{noteid}")
    int deleteNote(Integer noteid);
}
