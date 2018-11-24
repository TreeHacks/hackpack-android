package com.treehacks.hackpack_android.data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LocalNotesRepository implements INotesRepository {

    static private LocalNotesRepository instance = null;
    private List<Note> notesList = new ArrayList<>();

    static public LocalNotesRepository getInstance(){
        if(instance == null){
            instance = new LocalNotesRepository();
        }
        return instance;
    }

    public List<Note> getNotesList() {
        return notesList;
    }

    public void add(Note note){
        String id = UUID.randomUUID().toString();
        note.setId(id);
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

    @Override
    public void update(Note newNote) {
        for (Note note:notesList) {
            if(note.getId().equals(newNote.getId())){
                note.update(newNote.getTitle(), newNote.getNote());
            }
        }
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
