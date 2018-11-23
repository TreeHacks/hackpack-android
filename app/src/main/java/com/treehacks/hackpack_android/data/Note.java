package com.treehacks.hackpack_android.data;

public class Note {

    private String id = "";
    private String title = "";
    private String note = "";
    private boolean isPinned = false;
    private boolean isBookmarked = false;

    public Note(String _title, String _note){
        title = _title;
        note = _note;
    }

    public Note update(String _title, String _note){
        title = _title;
        note = _note;
        return this;
    }


    public String getId() {
        return id;
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
