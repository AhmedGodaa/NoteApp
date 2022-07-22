package com.examplez.noteapp.domain.use_case

import com.examplez.noteapp.domain.model.Note
import com.examplez.noteapp.domain.repository.NoteRepo

class DeleteNote (private val repo:NoteRepo){
    suspend operator fun invoke(note: Note){
        repo.deleteNote(note)

    }

}