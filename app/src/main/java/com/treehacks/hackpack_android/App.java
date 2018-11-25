package com.treehacks.hackpack_android;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.treehacks.hackpack_android.data.model.Note;
import com.treehacks.hackpack_android.data.repository.DummyNotesRepository;
import com.treehacks.hackpack_android.data.repository.INotesRepository;
import com.treehacks.hackpack_android.data.repository.LocalNotesRepository;

import java.util.List;

public class App extends Application {

    boolean testingMode = false;

    private String prefKey = BuildConfig.APPLICATION_ID + "notesList";

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public INotesRepository getNotesRepository(){
        if(testingMode){
            return DummyNotesRepository.getInstance(this);
        }
        return LocalNotesRepository.getInstance(this);
    }

    public SharedPreferences getSharedPrefs(){
        return this.getSharedPreferences(BuildConfig.APPLICATION_ID,Context.MODE_PRIVATE);
    }

    public String getPrefKey() { return prefKey; }
      

    public void saveNotes(){
        List<Note> noteList = getNotesRepository().getNotesList();
        Gson gson = new Gson();
        String json = gson.toJson(noteList);
        getSharedPrefs().edit()
                .putString(prefKey,json)
                .apply();
    }
}
