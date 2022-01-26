package com.motion.notesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NoteAdapter adapter;
    public static List<Note> noteList;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecycler();
        fab.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, AddNoteActivity.class));
        });
    }

    private void initRecycler() {
        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.fab_add);
        noteList = new ArrayList<>();
        adapter = new NoteAdapter(noteList);
        getDataFromDb();
        if (noteList.isEmpty()) {
            noteList.add(new Note("clean", "architekture", "Monday", 2));
            noteList.add(new Note("clean", "architekture", "Monday", 2));
            noteList.add(new Note("clean", "architekture", "Monday", 2));
            noteList.add(new Note("clean", "architekture", "Monday", 2));
            noteList.add(new Note("clean", "architekture", "Monday", 2));
            noteList.add(new Note("clean", "architekture", "Monday", 2));
            noteList.add(new Note("clean", "architekture", "Monday", 2));
            noteList.add(new Note("clean", "architekture", "Monday", 2));
            noteList.add(new Note("clean", "architekture", "Monday", 2));
            noteList.add(new Note("clean", "architekture", "Monday", 2));
            noteList.add(new Note("clean", "architekture", "Monday", 2));
            noteList.add(new Note("clean", "architekture", "Monday", 2));
            noteList.add(new Note("clean", "architekture", "Monday", 2));
        }
        //some comment
        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                noteList.remove(viewHolder.getAdapterPosition());
            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(adapter);
        adapter.setOnNoteClickListener(new OnNoteClickListener() {
            @Override
            public void onNoteClick(int position) {
                remove(position);
                Toast.makeText(getApplicationContext(), position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNoteLongClick(int position) {

            }
        });

    }
   private void getDataFromDb(){
    List<Note>noteListFromDb=App.dataBase.noteDao().getAllNote();
    noteList.clear();
    noteList.addAll(noteListFromDb);
    }
    private void remove(int position){
        Note note=noteList.get(position);
        App.dataBase.noteDao().deleteNote(note);
        getDataFromDb();
        adapter.notifyDataSetChanged();

    }
}