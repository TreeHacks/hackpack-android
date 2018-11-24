package com.treehacks.hackpack_android;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.treehacks.hackpack_android.data.INotesRepository;
import com.treehacks.hackpack_android.data.Note;
import com.treehacks.hackpack_android.data.LocalNotesRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String TAG = MainActivity.class.getSimpleName();

    private ListView noteListView;

    private INotesRepository notesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteListView = findViewById(R.id.noteListView);
        TextView takeNoteView = findViewById(R.id.takeNote);
        ImageView takeAudioNoteView = findViewById(R.id.takeAudioNoteView);

        notesManager = LocalNotesRepository.getInstance();

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

    private void startTakeNoteActivity(Note note){
        Intent intent = new Intent(this, NotesActivity.class);
        intent.putExtra("noteId",note.getId());
        startActivity(intent);
    }

    private void populateNotes(){

        final List<Note> noteList = notesManager.getNotesList();

        final ArrayAdapter<Note> noteArrayAdapter = new ArrayAdapter<Note>(
                this, R.layout.note_card_view, R.id.note, noteList);

        noteListView.setAdapter(noteArrayAdapter);

        noteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Note note = (Note)parent.getAdapter().getItem(position);
                startTakeNoteActivity(note);
            }
        });
    }


}
