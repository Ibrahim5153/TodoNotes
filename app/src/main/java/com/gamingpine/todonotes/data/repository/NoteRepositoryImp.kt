package com.gamingpine.todonotes.data.repository

import com.gamingpine.todonotes.data.datasource.NoteDao
import com.gamingpine.todonotes.domain.model.Note
import com.gamingpine.todonotes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by muhammadibrahim on 12/08/2023
 *
 * Desc: Implementation of notes repository
 */

class NoteRepositoryImp(private val noteDao: NoteDao) : NoteRepository {
    override fun getAllNotes(): Flow<List<Note>> {
        return noteDao.getAllNotes()
    }

    override suspend fun getNote(id: Int): Note? {
       return noteDao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        noteDao.addNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }
}