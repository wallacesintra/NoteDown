package com.example.notedown.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

import java.util.Date

@Entity
data class NoteEntity(
    val title: String = "",
    val note: String = "",
    val category: String = "",
//    val time: Date,
    @PrimaryKey(autoGenerate = true) val id:Int? = null
)