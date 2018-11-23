package com.treehacks.hackpack_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.treehacks.hackpack_android.data.INotesManager;
import com.treehacks.hackpack_android.data.Note;
import com.treehacks.hackpack_android.data.NotesManager;

public class NotesActivity extends AppCompatActivity {

    private EditText titleView;
    private EditText noteView;
    private INotesManager notesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        notesManager = NotesManager.getInstance();

        titleView = findViewById(R.id.noteTitle);
        noteView = findViewById(R.id.note);

        noteView.requestFocus();

        noteView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_NEXT) {

                    noteView.clearFocus();
                    String titleValue = titleView.getText().toString();
                    String notesValue = noteView.getText().toString();
                    Note note = new Note(titleValue,notesValue);
                    notesManager.add(note);
                    handled = true;
                }

                return handled;
            }
        });
    }




}
