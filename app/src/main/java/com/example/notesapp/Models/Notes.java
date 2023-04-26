package com.example.notesapp.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "notes")
public class Notes implements Serializable {

    public Notes(int id, String title, String note) {
        this.id = id;
        this.title = title;
        this.note = note;
    }

    @Ignore
    public Notes(String title, String note) {
        this.title = title;
        this.note = note;
    }

    @PrimaryKey(autoGenerate = true)
    int id =0;

    @ColumnInfo(name = "title")
    String title = "";

    @ColumnInfo(name = "note")
    String note="";


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
