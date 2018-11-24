package com.treehacks.hackpack_android.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.treehacks.hackpack_android.App;
import com.treehacks.hackpack_android.R;
import com.treehacks.hackpack_android.data.INotesRepository;
import com.treehacks.hackpack_android.data.Note;

public class NotesActivity extends AppCompatActivity {

    private EditText titleView;
    private EditText noteView;
    private INotesRepository notesRepo;
    private String noteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){
            noteId = bundle.getString("noteId");
        }

        notesRepo = ((App)getApplication()).getNotesRepository();

        titleView = findViewById(R.id.noteTitle);
        noteView = findViewById(R.id.note);

        ImageButton imageButton = findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNote();
                startMainActivity();
                return;
            }
        });


        if(noteId!=null){
            Note note = notesRepo.getNoteById(noteId);
            titleView.setText(note.getTitle());
            noteView.setText(note.getNote());
            return;
        }

        noteView.requestFocus();

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
        notesRepo.add(note);
    }

    private void updateNote(){
        String titleValue = titleView.getText().toString();
        String notesValue = noteView.getText().toString();
        Note note = notesRepo.getNoteById(noteId);
        note.update(titleValue,notesValue);
    }


}