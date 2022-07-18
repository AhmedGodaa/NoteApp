package com.examplez.noteapp.domain.repository
import com.examplez.noteapp.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepo {

    fun getAllNotes(): Flow<List<Note>>
    suspend fun getNoteById(noteId: Int): Note?
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(note: Note);
}