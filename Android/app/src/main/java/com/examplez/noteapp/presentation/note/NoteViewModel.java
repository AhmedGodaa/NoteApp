package com.examplez.noteapp.presentation.note;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.examplez.noteapp.domain.model.Note;

import java.util.List;

import kotlinx.coroutines.flow.Flow;


public class NoteViewModel extends AndroidViewModel {
    NoteRepository noteRepository;


    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRepository = new NoteRepository(application);

    }

    public Flow<List<Note>> getAllNotes() {
        return noteRepository.getAllNotes();

    }


    public void insertNote(Note note) {
        noteRepository.insertNote(note);


    }

    public void deleteNote(Note note) {
        noteRepository.deleteNote(note);


    }


}
