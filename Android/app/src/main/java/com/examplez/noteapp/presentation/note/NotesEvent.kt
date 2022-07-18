package com.examplez.noteapp.presentation.note

import com.examplez.noteapp.domain.model.Note
import com.examplez.noteapp.domain.util.NoteOrder

sealed class NotesEvent{
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}