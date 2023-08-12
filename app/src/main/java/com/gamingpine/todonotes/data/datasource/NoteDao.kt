package com.gamingpine.todonotes.data.datasource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gamingpine.todonotes.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getAllNotes(): Flow<List<Note>>

    @Query("SELECT * FROM note WHERE id=:id")
    suspend fun getNoteById(id: Int): Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: Note): Long

    @Delete
    suspend fun deleteNote(note: Note )
}