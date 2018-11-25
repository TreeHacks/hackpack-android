package com.treehacks.hackpack_android.data.model;

public class Note {

    private String id = "";
    private String title = "";
    private String note = "";
    private boolean isPinned = false;
    private boolean isBookmarked = false;

    public Note(String title, String note){
        this.title = title;
        this.note = note;
    }

    public Note update(String title, String note){
        this.title = title;
        this.note = note;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s\n%s",title,note);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isPinned() {
        return isPinned;
    }

    public void setPinned(boolean pinned) {
        isPinned = pinned;
    }

    public boolean isBookmarked() {
        return isBookmarked;
    }

    public void setBookmarked(boolean bookmarked) {
        isBookmarked = bookmarked;
    }
}
