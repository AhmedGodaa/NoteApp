package com.examplez.noteapp.listeners;

import com.examplez.noteapp.entities.Note;

public interface NoteListener {
    void onNoteClicked(Note note,int position);
}
