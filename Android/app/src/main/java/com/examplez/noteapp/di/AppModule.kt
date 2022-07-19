package com.examplez.noteapp.di

import android.app.Application
import androidx.room.Room
import com.examplez.noteapp.common.Constants
import com.examplez.noteapp.data.db.NoteDB
import com.examplez.noteapp.data.repository.NoteRepoImpl
import com.examplez.noteapp.domain.repository.NoteRepo
import com.examplez.noteapp.domain.use_case.AddNote
import com.examplez.noteapp.domain.use_case.DeleteNote
import com.examplez.noteapp.domain.use_case.GetNotes
import com.examplez.noteapp.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
//    cause it will need to take argument as instance of NoteDatabase
    fun provideNoteDatabase(app: Application): NoteDB {
        return Room.databaseBuilder(
            app,
            NoteDB::class.java,
            Constants.DATABASE_NAME
        ).build()

    }

    @Provides
    @Singleton
//    cause it will need to take argument as instance of NoteDatabase
    fun provideNoteRepo(db: NoteDB): NoteRepo {
        return NoteRepoImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun providesUseCases(repo: NoteRepo): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repo),
            deleteNote = DeleteNote(repo),
            addNote = AddNote(repo)

        )
    }


}