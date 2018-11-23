package com.treehacks.hackpack_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.treehacks.hackpack_android.data.INotesManager;
import com.treehacks.hackpack_android.data.Note;
import com.treehacks.hackpack_android.data.NotesManager;

public class NotesActivity extends AppCompatActivity {

    private EditText titleView;
    private EditText noteView;
    private ImageButton imageButton;
    private INotesManager notesManager;
    private String noteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){
            noteId = bundle.getString("noteId");
        }


        notesManager = NotesManager.getInstance();

        titleView = findViewById(R.id.noteTitle);
        noteView = findViewById(R.id.note);
        imageButton = findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNote();
                startMainActivity();
                return;
            }
        });


        if(noteId!=null){
            Note note = notesManager.getNoteById(noteId);
            titleView.setText(note.getTitle());
            noteView.setText(note.getNote());
            return;
        }

        noteView.requestFocus();

//        noteView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                boolean handled = false;
//                if (actionId == EditorInfo.IME_ACTION_NEXT) {
//                    noteView.clearFocus();
//                    addNote();
//                    handled = true;
//                }
//                return handled;
//            }
//        });
    }


    private void startMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void addNote(){
        if(noteId!=null){
            updateNote();
            return;
        }
        String titleValue = titleView.getText().toString();
        String notesValue = noteView.getText().toString();

        if(titleValue.isEmpty() && notesValue.isEmpty()) return;

        Note note = new Note(titleValue,notesValue);
        notesManager.add(note);
    }

    private void updateNote(){
        String titleValue = titleView.getText().toString();
        String notesValue = noteView.getText().toString();
        Note note = notesManager.getNoteById(noteId);
        note.update(titleValue,notesValue);
    }




}
