package com.example.notedown.data.remote

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteEntity(
    val title: String,
    val note: String,
    val category: String,
    @PrimaryKey(autoGenerate = true) val id:Int? = null
)