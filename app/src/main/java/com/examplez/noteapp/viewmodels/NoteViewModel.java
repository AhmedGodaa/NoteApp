package com.examplez.noteapp.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.examplez.noteapp.databases.NoteDatabase;
import com.examplez.noteapp.entities.Note;
import com.examplez.noteapp.repositories.NoteRepository;

import java.util.List;


public class NoteViewModel extends AndroidViewModel {
    private NoteRepository noteRepository;


    public NoteViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Note>> getAllNotes() {
        return noteRepository.getAllNotes();

    }


    public void insertNote(Note note) {
        NoteDatabase.databaseWriteExecutor.execute(() -> {
            noteRepository.insertNote(note);
        });


    }

    public void deleteNote(Note note) {
        NoteDatabase.databaseWriteExecutor.execute(() -> {
            noteRepository.deleteNote(note);
        });

    }


}
