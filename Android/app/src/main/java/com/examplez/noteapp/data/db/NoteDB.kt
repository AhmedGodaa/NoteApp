package com.examplez.noteapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.examplez.noteapp.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDB  :RoomDatabase(){
    abstract val noteDao:NoteDao
}