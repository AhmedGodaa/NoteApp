package com.examplez.noteapp.domain.use_case

import com.examplez.noteapp.domain.model.Note
import com.examplez.noteapp.domain.repository.NoteRepo
import com.examplez.noteapp.domain.util.NoteOrder
import com.examplez.noteapp.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(
    private val repo: NoteRepo
) {
    operator fun invoke(noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)): Flow<List<Note>> {
        return repo.getAllNotes().map { notes ->
            when (noteOrder.orderType) {
                is OrderType.Ascending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.dateTime.lowercase() }
                        is NoteOrder.Color -> notes.sortedBy { it.color.lowercase() }
                    }

                }
                is OrderType.Descending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.dateTime.lowercase() }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color.lowercase() }
                    }

                }
            }
        }
    }

}