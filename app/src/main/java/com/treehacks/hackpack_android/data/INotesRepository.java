package com.treehacks.hackpack_android.data;

import java.util.List;

public interface INotesRepository {
    List<Note> getNotesList();
    void add(Note note);
    void update(Note note);
    Note getNoteById(String id);
    boolean deleteNoteById(String id);
}
