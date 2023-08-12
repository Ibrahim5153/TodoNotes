package com.gamingpine.todonotes.domain.usecase

import com.gamingpine.todonotes.domain.model.Note
import com.gamingpine.todonotes.domain.repository.NoteRepository

/**
 * Created by muhammadibrahim on 12/08/2023
 *
 * Desc: Use-Case to delete note
 */

class DeleteNoteUseCase(private val noteRepository: NoteRepository) {

    suspend operator fun invoke(note: Note) {
        noteRepository.deleteNote(note)
    }
}