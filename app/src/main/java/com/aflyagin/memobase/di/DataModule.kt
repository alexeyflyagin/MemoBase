package com.aflyagin.memobase.di

import android.content.Context
import androidx.room.Room
import com.aflyagin.memobase.data.NoteRepositoryImpl
import com.aflyagin.memobase.data.NoteService
import com.aflyagin.memobase.data.database.NoteDatabase
import com.aflyagin.memobase.data.database.NoteServiceImpl
import com.aflyagin.memobase.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(
        @ApplicationContext context: Context
    ): NoteDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = NoteDatabase::class.java,
            name = "noteDatabase"
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteService(
        noteDatabase: NoteDatabase
    ): NoteService {
        return NoteServiceImpl(noteDatabase)
    }

    @Provides
    @Singleton
    fun provideNoteRepository(
        noteService: NoteService
    ): NoteRepository {
        return NoteRepositoryImpl(noteService)
    }
}