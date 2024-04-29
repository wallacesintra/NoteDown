package com.example.notedown.presentation.models

import java.util.Date

data class NoteModel(
    val title: String = "",
    val notes: String = "",
    val category: String = "",
    val id:Int? = null
//    val time: Date? = null
)