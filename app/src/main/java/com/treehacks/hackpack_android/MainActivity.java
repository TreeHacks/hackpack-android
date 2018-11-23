package com.treehacks.hackpack_android;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.treehacks.hackpack_android.data.INotesManager;
import com.treehacks.hackpack_android.data.Note;
import com.treehacks.hackpack_android.data.NotesManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String TAG = MainActivity.class.getSimpleName();

    private TextView takeNoteView;
    private ImageView takeAudioNoteView;
    private LinearLayout notesContainer;
    private LayoutInflater inflater;

    private INotesManager notesManager;

    private int currentNoteCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflater = LayoutInflater.from(this);

        takeNoteView = findViewById(R.id.takeNote);
        takeAudioNoteView = findViewById(R.id.takeAudioNote);
        notesContainer = findViewById(R.id.notesContainer);

        notesManager = NotesManager.getInstance();

        takeNoteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTakeNoteActivity();
            }
        });

        populateNotes();
    }


    private void startTakeNoteActivity(){
        Intent intent = new Intent(this, NotesActivity.class);
        startActivity(intent);
    }

    private void populateNotes(){
        List<Note> noteList = notesManager.getNotesList();

        for(Note note: noteList){
            createNewNoteCard(note);
            currentNoteCount++;
        }
    }


    private void createNewNoteCard(Note note){
        View itemView =  inflater.inflate(R.layout.note_card_view,notesContainer);
        TextView titleView = itemView.findViewById(R.id.title);
        TextView noteView = itemView.findViewById(R.id.note);

        if(note.getTitle().isEmpty()){
            titleView.setVisibility(View.GONE);
        }else{
            titleView.setVisibility(View.VISIBLE);
        }
        if(note.getNote().isEmpty()){
            titleView.setVisibility(View.GONE);
        }else{
            titleView.setVisibility(View.VISIBLE);
        }

        titleView.setText(note.getTitle());
        noteView.setText(note.getNote());

        final Note noteRefernece = note;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTakeNoteActivity(noteRefernece);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        populateNotes();
    }

    private void startTakeNoteActivity(Note note){
        Intent intent = new Intent(this, NotesActivity.class);
        intent.putExtra("noteId",note.getId());
        startActivity(intent);
    }

}
