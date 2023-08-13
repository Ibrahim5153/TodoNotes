package com.gamingpine.todonotes.di

import android.app.Application
import androidx.room.Room
import com.gamingpine.todonotes.data.datasource.NoteDatabase
import com.gamingpine.todonotes.data.repository.NoteRepositoryImp
import com.gamingpine.todonotes.domain.repository.NoteRepository
import com.gamingpine.todonotes.domain.usecase.AddNoteUseCase
import com.gamingpine.todonotes.domain.usecase.DeleteNoteUseCase
import com.gamingpine.todonotes.domain.usecase.GetAllNotesUseCase
import com.gamingpine.todonotes.domain.usecase.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by muhammadibrahim on 12/08/2023
 *
 * Desc: Hilt app module to provide singletons
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(noteApplication: Application): NoteDatabase {
        return Room.databaseBuilder(
            noteApplication,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(noteDatabase: NoteDatabase): NoteRepository {
        return NoteRepositoryImp(noteDatabase.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCaseWrapper(noteRepository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            GetAllNotesUseCase(noteRepository),
            DeleteNoteUseCase(noteRepository),
            AddNoteUseCase(noteRepository)
        )
    }
}