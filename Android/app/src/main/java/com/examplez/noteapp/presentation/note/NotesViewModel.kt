package com.examplez.noteapp.presentation.note

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.examplez.noteapp.domain.model.Note
import com.examplez.noteapp.domain.use_case.NoteUseCases
import com.examplez.noteapp.domain.util.NoteOrder
import com.examplez.noteapp.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
) : ViewModel() {

    private val _state = mutableStateOf(NotesState())
    private val state: State<NotesState> = _state
    private var deletedNote: Note? = null
    private var getNoteJob: Job? = null

    init {
        getNotes(NoteOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.Order -> {
                if (state.value.noteOrder::class == event.noteOrder::class &&
                    state.value.noteOrder.orderType == event.noteOrder.orderType
                ) {
                    return
                }


            }
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    noteUseCases.deleteNote(event.note)
                    deletedNote = event.note
                }

            }
            is NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    noteUseCases.addNote(deletedNote ?: return@launch)
                    deletedNote = null
                }


            }
            is NotesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )


            }
        }
    }

    private fun getNotes(noteOrder: NoteOrder) {
        getNoteJob?.cancel()
        getNoteJob = noteUseCases.getNotes(noteOrder).onEach { note ->
            _state.value = state.value.copy(
                notes = note,
                noteOrder = noteOrder
            )
        }.launchIn(viewModelScope)
    }


}