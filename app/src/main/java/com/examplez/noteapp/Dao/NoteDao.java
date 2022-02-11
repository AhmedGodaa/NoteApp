package com.examplez.noteapp.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.examplez.noteapp.entities.Note;

import java.util.List;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM note ORDER BY id DESC")
    public LiveData<List<Note>> getAllNotes();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertNote(Note note);

    @Delete
    public void deleteNote(Note note);


}
