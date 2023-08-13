package com.gamingpine.todonotes.domain.usecase

import com.gamingpine.todonotes.domain.model.InvalidNoteException
import com.gamingpine.todonotes.domain.model.Note
import com.gamingpine.todonotes.domain.repository.NoteRepository

/**
 * Created by muhammadibrahim on 13/08/2023
 *
 * Desc: this is a usecase to add the new note to database
 * this will also be used to restore delted note
 */

class AddNoteUseCase (private val repository: NoteRepository) {
    private companion object {
       const val EXCEPTION_MESSAGE: String = "the note {property} must not be null or empty."
    }

    private fun throwInvalidNoteStateException(invalidState: String) {
        throw InvalidNoteException(EXCEPTION_MESSAGE.format(invalidState))
    }

    @Throws(InvalidNoteException::class)
     suspend operator fun invoke(note: Note) {
         if(note.title.isNullOrEmpty()) {
            throwInvalidNoteStateException("title")
         } else if(note.description.isNullOrEmpty()) {
             throwInvalidNoteStateException("description")
         }

        repository.insertNote(note)
    }
}