package com.treehacks.hackpack_android.data.repository;

import com.treehacks.hackpack_android.data.model.Note;

import java.util.List;

public interface INotesRepository {
    List<Note> getNotesList();
    void add(Note note);
    void update(Note note);
    Note getNoteById(String id);
    boolean deleteNoteById(String id);
}
