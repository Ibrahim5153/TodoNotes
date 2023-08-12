package com.gamingpine.todonotes.domain.usecase

import com.gamingpine.todonotes.domain.model.Note
import com.gamingpine.todonotes.domain.repository.NoteRepository
import com.gamingpine.todonotes.domain.util.NoteOrder
import com.gamingpine.todonotes.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Created by muhammadibrahim on 12/08/2023
 *
 * Desc: Use-Case to get all notes
 */

class GetAllNotesUseCase(private val noteRepository: NoteRepository) {

    operator fun invoke(noteOrder: NoteOrder = NoteOrder.Date(OrderType.DESCENDING)): Flow<List<Note>> {

        return noteRepository.getAllNotes().map { notes ->

            when (noteOrder.orderType) {
                OrderType.ASCENDING -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timeStamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                OrderType.DESCENDING -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timeStamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }

        }
    }

}

