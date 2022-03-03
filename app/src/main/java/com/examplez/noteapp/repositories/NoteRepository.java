package com.examplez.noteapp.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.examplez.noteapp.Dao.NoteDao;
import com.examplez.noteapp.databases.NoteDatabase;
import com.examplez.noteapp.entities.Note;

import java.util.List;

public class NoteRepository {
    NoteDao noteDao;

    public NoteRepository(Application application) {
        NoteDatabase db = NoteDatabase.getDatabase(application);
        noteDao = db.noteDao();
    }


    public LiveData<List<Note>> getAllNotes() {
        return noteDao.getAllNotes();
    }


    public void insertNote(Note note) {
        NoteDatabase.databaseWriteExecutor.execute(() -> noteDao.insertNote(note));


    }

    public void deleteNote(Note note) {
        NoteDatabase.databaseWriteExecutor.execute(() -> noteDao.deleteNote(note));

    }

}
