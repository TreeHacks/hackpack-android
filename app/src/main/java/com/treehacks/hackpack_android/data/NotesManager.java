package com.treehacks.hackpack_android.data;

import java.util.ArrayList;
import java.util.List;

public class NotesManager implements INotesManager{

    static private NotesManager instance = null;
    private List<Note> notesList = new ArrayList<>();

    static public NotesManager getInstance(){
        if(instance == null){
            instance = new NotesManager();
        }
        return instance;
    }

    public List<Note> getNotesList() {
        return notesList;
    }

    public void add(Note note){
        notesList.add(note);
    }

    public Note getNoteById(String id){
        for (Note note:notesList) {
            if(note.getId().equals(id)){
                return note;
            }
        }

        return null;
    }

    public boolean deleteNoteById(String id){
        for (Note note:notesList) {
            if(note.getId().equals(id)){
                notesList.remove(note);
                return true; //Success | Note with given id successfully deleted
            }
        }
        return false; // Failure | Note with given id not found
    }
}
