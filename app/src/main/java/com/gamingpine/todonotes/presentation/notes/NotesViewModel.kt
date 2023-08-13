package com.gamingpine.todonotes.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gamingpine.todonotes.domain.model.Note
import com.gamingpine.todonotes.domain.usecase.NoteUseCases
import com.gamingpine.todonotes.domain.util.NoteOrder
import com.gamingpine.todonotes.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by muhammadibrahim on 12/08/2023
 *
 * Desc: Viewmodel class for displaying notes
 */

@HiltViewModel
class NotesViewModel @Inject constructor(private val useCases: NoteUseCases) : ViewModel() {


    private val _state = mutableStateOf(NoteScreenState())
    val state: State<NoteScreenState> = _state

    private var recentDeletedNote: Note? = null

    private var notesJob: Job? = null

    init {
        getNotes(NoteOrder.Date(OrderType.DESCENDING))
    }

    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    useCases.deleteNoteUseCase(event.note)
                    recentDeletedNote = event.note
                }
            }

            is NotesEvent.OrderNotes -> TODO()
            NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    useCases.addNoteUseCase(recentDeletedNote ?: return@launch)
                    recentDeletedNote = null
                }
            }

            NotesEvent.ToggleOrderSection -> {
                _state.value = _state.value.copy(
                    isOrderSectionVisible = !_state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getNotes(noteOrder: NoteOrder) {
        notesJob?.cancel()
        notesJob = useCases.getAllNotesUseCase(noteOrder).onEach { notes ->
            _state.value = _state.value.copy(
                notes = notes,
                noteOrder = noteOrder
            )
        }.launchIn(viewModelScope)
    }
}