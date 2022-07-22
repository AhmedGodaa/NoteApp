package com.examplez.noteapp.presentation.note;

import com.examplez.noteapp.domain.model.Note;

public interface NoteListener {
    void onNoteClicked(Note note,int position);
}
