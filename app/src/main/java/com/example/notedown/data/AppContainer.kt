package com.example.notedown.data

import android.content.Context
import androidx.room.Room
import com.example.notedown.data.remote.NoteDatabase

interface AppContainer {
    val noteDatabase: NoteDatabase
}

class DefaultContainer(private val applicationContext: Context): AppContainer {
    override val noteDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            NoteDatabase::class.java,
            "notes.db"
        ).build()
    }
}