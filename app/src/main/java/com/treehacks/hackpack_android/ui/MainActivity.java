package com.treehacks.hackpack_android.ui;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.treehacks.hackpack_android.App;
import com.treehacks.hackpack_android.R;
import com.treehacks.hackpack_android.data.repository.INotesRepository;
import com.treehacks.hackpack_android.data.model.Note;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String TAG = MainActivity.class.getSimpleName();

    private ListView noteListView;

    private INotesRepository notesRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteListView = findViewById(R.id.noteListView);
        TextView takeNoteView = findViewById(R.id.takeNote);

        //You can use below AudioNoteView to add audio note functionality to the app
//        ImageView takeAudioNoteView = findViewById(R.id.takeAudioNoteView);

        notesRepo = ((App)getApplication()).getNotesRepository();

        takeNoteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTakeNoteActivity();
            }
        });

        populateNotes();
    }

    @Override
    protected void onResume() {
        super.onResume();
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

        final List<Note> noteList = notesRepo.getNotesList();

        final ArrayAdapter<Note> noteArrayAdapter = new ArrayAdapter<Note>(
                this, R.layout.note_card_view, R.id.note, noteList);

        noteArrayAdapter.notifyDataSetChanged();

        noteListView.setAdapter(noteArrayAdapter);
        noteListView.setPadding(8,8,8,8);
        noteListView.setDividerHeight(8);

        noteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Note note = (Note)parent.getAdapter().getItem(position);
                startTakeNoteActivity(note);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        ((App)getApplication()).saveNotes();
    }
}
