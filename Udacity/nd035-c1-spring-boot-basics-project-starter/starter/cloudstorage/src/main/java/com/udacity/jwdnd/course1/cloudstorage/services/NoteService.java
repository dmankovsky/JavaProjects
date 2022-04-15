package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.Mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.SingleNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private final NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating NoteService Bean.");
    }

    public int addNote(SingleNote note, int userId){
        return noteMapper.addNote(new SingleNote(0, note.getNoteTitle(), note.getNoteDescription(), userId));
    }

    public int editNote(SingleNote note) {return noteMapper.editNote(note);}

    public int deleteNote(Integer noteId) {return noteMapper.deleteNote(noteId);}

    public boolean isOnlyNote(Integer userId, String noteTitle, String noteDescription){
        Optional<SingleNote> note = Optional.ofNullable(noteMapper.isOnlyNote(userId, noteTitle, noteDescription));
        return (note.isEmpty());
    }

    public List<SingleNote> getAllNotesForUser(Integer userId) {
        return noteMapper.getAllNotesForUser(userId);
    }
}
