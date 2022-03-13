package com.udacity.jwdnd.course1.cloudstorage.model;

public class NoteOverviewForm {
    private String username;
    private String noteText;

    public NoteOverviewForm(String username, String noteText) {
        this.username = username;
        this.noteText = noteText;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }
}
