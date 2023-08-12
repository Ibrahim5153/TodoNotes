package com.gamingpine.todonotes.presentation.notes

import com.gamingpine.todonotes.domain.model.Note
import com.gamingpine.todonotes.domain.util.NoteOrder
import com.gamingpine.todonotes.domain.util.OrderType

data class NoteScreenState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.ASCENDING),
    val isOrderSectionVisible: Boolean = false
)
