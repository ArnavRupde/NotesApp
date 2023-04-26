package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.notesapp.Database.RoomDB;
import com.example.notesapp.Models.Notes;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fabAdd;
    RecyclerView recyclerNotes;
    RoomDB roomDB;

    private void showNotes() {
        ArrayList<Notes> allNotes = (ArrayList<Notes>) roomDB.mainDAO().getAll();

        recyclerNotes.setAdapter(new RecyclerNotesAdapter(this, allNotes));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        initNotes();

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, NoteActivity.class);
                startActivity(i);
            }
        });
    }

    private void initNotes() {
        fabAdd = findViewById(R.id.fab_add);
        recyclerNotes = findViewById(R.id.recycler_notes);

        recyclerNotes.setLayoutManager(new GridLayoutManager(this, 2));

        roomDB = RoomDB.getInstance(this);

        showNotes();
    }
}