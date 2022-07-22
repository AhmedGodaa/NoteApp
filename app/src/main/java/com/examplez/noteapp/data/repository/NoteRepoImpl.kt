package com.examplez.noteapp.data.repository

import com.examplez.noteapp.data.db.NoteDao
import com.examplez.noteapp.domain.model.Note
import com.examplez.noteapp.domain.repository.NoteRepo
import kotlinx.coroutines.flow.Flow

class NoteRepoImpl(
private val dao: NoteDao
) : NoteRepo {

    override fun getAllNotes(): Flow<List<Note>> {
        return  dao.getAllNotes()
    }

    override suspend fun getNoteById(noteId: Int): Note? {
       return dao.getNoteById(noteId)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }

}