package com.treehacks.hackpack_android;

import android.app.Application;

import com.treehacks.hackpack_android.data.DummyNotesRepository;
import com.treehacks.hackpack_android.data.INotesRepository;
import com.treehacks.hackpack_android.data.LocalNotesRepository;

public class App extends Application {

    boolean testingMode = false;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public INotesRepository getNotesRepository(){
        if(testingMode){
            return DummyNotesRepository.getInstance();
        }
        return LocalNotesRepository.getInstance();
    }



}
