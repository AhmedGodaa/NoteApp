package com.examplez.noteapp.presentation.note;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.examplez.noteapp.data.db.NoteDao;
import com.examplez.noteapp.data.db.NoteDatabase;
import com.examplez.noteapp.domain.model.Note;

import java.util.List;

import kotlinx.coroutines.flow.Flow;

public class NoteRepository {
    NoteDao noteDao;

    public NoteRepository(Application application) {
        NoteDatabase db = NoteDatabase.getDatabase(application);
        noteDao = db.noteDao();
    }


    public Flow<List<Note>> getAllNotes() {
        return noteDao.getAllNotes();
    }


    public void insertNote(Note note) {
        NoteDatabase.databaseWriteExecutor.execute(() -> noteDao.insertNote(note));


    }

    public void deleteNote(Note note) {
        NoteDatabase.databaseWriteExecutor.execute(() -> noteDao.deleteNote(note));

    }

}
