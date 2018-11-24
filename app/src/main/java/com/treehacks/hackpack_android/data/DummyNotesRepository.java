package com.treehacks.hackpack_android.data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DummyNotesRepository implements INotesRepository {

    static private DummyNotesRepository instance = null;
    private List<Note> notesList = new ArrayList<>();

    static public DummyNotesRepository getInstance(){
        if(instance == null){
            instance = new DummyNotesRepository();
        }
        return instance;
    }


    public List<Note> getNotesList() {
        int count = 50;
        if(notesList.size()== 0){
            for(int i=0; i<count; i++){
                Note n = new Note(UUID.randomUUID().toString(),UUID.randomUUID().toString());
                String id = UUID.randomUUID().toString();
                n.setId(id);
                notesList.add(n);
            }
        }
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
