package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.notesapp.Database.RoomDB;
import com.example.notesapp.Models.Notes;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NoteActivity extends AppCompatActivity {

    FloatingActionButton fabDone;
    FloatingActionButton fabBack;
    FloatingActionButton fabDelete;
    RoomDB roomDB;

    EditText ed_title;
    EditText ed_note;
    boolean is_new_note;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        fabDone = findViewById(R.id.fab_done);
        fabBack = findViewById(R.id.fab_back);
        fabDelete = findViewById(R.id.fab_delete);

        Intent intent = getIntent();

        is_new_note= true;
        ed_title=(EditText)findViewById(R.id.title);
        ed_note=(EditText)findViewById(R.id.note);
        if (intent.hasExtra("id")) {
            is_new_note=false;
            id=intent.getIntExtra("id", -1);
            ed_title.setText(intent.getStringExtra("title"));
            ed_note.setText(intent.getStringExtra("note"));
            fabDelete.setVisibility(View.VISIBLE);
        }

        roomDB = RoomDB.getInstance(this);

        fabDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (is_new_note) {
                    roomDB.mainDAO().insert(new Notes(ed_title.getText().toString(), ed_note.getText().toString()));
                } else {
                    roomDB.mainDAO().update(id, ed_title.getText().toString(), ed_note.getText().toString());
                }
                finish();
            }
        });

        fabDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roomDB.mainDAO().delete(new Notes(id, ed_title.getText().toString(), ed_note.getText().toString()));
                finish();
            }
        });


        fabBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}