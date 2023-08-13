package com.gamingpine.todonotes.presentation.notes

import com.gamingpine.todonotes.domain.model.Note
import com.gamingpine.todonotes.domain.util.NoteOrder

/**
 * Created by muhammadibrahim on 13/08/2023
 *
 * Desc: Event class for notes home screen to send event to viewmodel
 */

sealed class NotesEvent {
    data class OrderNotes(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}