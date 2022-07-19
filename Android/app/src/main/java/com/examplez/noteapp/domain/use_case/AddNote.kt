package com.examplez.noteapp.domain.use_case

import com.examplez.noteapp.domain.model.InvalidNoteException
import com.examplez.noteapp.domain.model.Note
import com.examplez.noteapp.domain.repository.NoteRepo

class AddNote(private val repo: NoteRepo) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw  InvalidNoteException("The title of note can't be empty")

        }
        if (note.subtitle.isBlank()) {
            throw  InvalidNoteException("The subtitle of note can't be empty")

        }
        if (note.noteText.isBlank()) {
            throw  InvalidNoteException("The body of note can't be empty")

        }
        repo.insertNote(note)
    }
}