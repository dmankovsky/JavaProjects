package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.Mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteOverviewForm;
import com.udacity.jwdnd.course1.cloudstorage.model.SingleNote;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class NoteService {
    private NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating NoteService Bean.");
    }

    public void addNote(NoteOverviewForm noteOverviewForm) {
        SingleNote newNote = new SingleNote();
        newNote.setUserId(noteOverviewForm.getUserId());
        noteMapper.addNote(newNote);
    }

    public List<SingleNote> getAllNotes() {
        return noteMapper.getAllNotes();
    }
}
