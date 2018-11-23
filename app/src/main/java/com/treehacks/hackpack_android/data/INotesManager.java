package com.treehacks.hackpack_android.data;

import java.util.List;

public interface INotesManager {
    List<Note> getNotesList();
    void add(Note note);
    Note getNoteById(String id);
    boolean deleteNoteById(String id);
}
