package com.udacity.jwdnd.course1.cloudstorage.model;

public class SingleNote {
    private Integer noteId;
    private String noteTitle;
    private String noteDescription;
    private Integer userId;

    public SingleNote(int i, String noteTitle, String noteDescription, int userId) {
        this.noteId = noteId;
        this.noteTitle = this.noteTitle;
        this.noteDescription = this.noteDescription;
        this.userId = this.userId;
    }

    public SingleNote() {

    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }

}
