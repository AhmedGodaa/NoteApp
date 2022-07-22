package com.examplez.noteapp.presentation.note

import com.examplez.noteapp.domain.model.Note
import com.examplez.noteapp.domain.util.NoteOrder
import com.examplez.noteapp.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
