package com.examplez.noteapp.domain.use_case

import com.examplez.noteapp.domain.model.Note
import com.examplez.noteapp.domain.repository.NoteRepo

class AddNote(private val repo: NoteRepo) {

    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()){

        }
        repo.insertNote(note)
    }
}