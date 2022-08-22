package com.udacity.jwdnd.course1.cloudstorage.model;

public class SingleNote {
    private Integer noteid;
    private String notetitle;
    private String notedescription;
    private Integer userid;

    public SingleNote(Integer noteId, String noteTitle, String noteDescription, int userId) {
        this.noteid = noteId;
        this.notetitle = noteTitle;
        this.notedescription = noteDescription;
        this.userid = userId;
    }

    public SingleNote() {

    }

    public Integer getNoteid() {
        return noteid;
    }

    public void setNoteid(Integer noteid) {
        this.noteid = noteid;
    }

    public String getNotetitle() {
        return notetitle;
    }

    public void setNotetitle(String notetitle) {
        this.notetitle = notetitle;
    }

    public String getNotedescription() {
        return notedescription;
    }

    public void setNotedescription(String notedescription) {
        this.notedescription = notedescription;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
