package com.treehacks.hackpack_android.data.repository;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.treehacks.hackpack_android.App;
import com.treehacks.hackpack_android.data.model.Note;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LocalNotesRepository implements INotesRepository {

    static private LocalNotesRepository instance = null;
    private List<Note> notesList = new ArrayList<>();
    private SharedPreferences sharedPreferences;
    private String prefsKey="";

    static public LocalNotesRepository getInstance(Application application){
        if(instance == null){
            instance = new LocalNotesRepository(application);
        }
        return instance;
    }

    public LocalNotesRepository(Application application){
        sharedPreferences = ((App)application).getSharedPrefs();
        prefsKey = ((App)application).getPrefKey();
    }

    public List<Note> getNotesList() {
        if(notesList.size() != 0) return notesList;
        Gson gson = new Gson();
        String json = sharedPreferences.getString(prefsKey, "");
        if(json.trim().isEmpty()){
            return notesList;
        }
        Type type = new TypeToken<List<Note>>(){}.getType();
        notesList = gson.fromJson(json,type);
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
