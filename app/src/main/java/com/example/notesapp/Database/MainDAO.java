package com.example.notesapp.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.notesapp.Models.Notes;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface MainDAO {

    @Insert(onConflict = REPLACE)
    void insert(Notes note);

    @Query("SELECT * from notes ORDER BY id DESC")
    List<Notes> getAll();

    @Query("UPDATE notes set title = :title, note = :note WHERE id= :id")
    void update(int id, String title, String note);

    @Delete
    void delete(Notes note);
}
