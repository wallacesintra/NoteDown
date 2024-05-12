package com.example.notedown.presentation.models

data class NoteElementState(
    val id: Int? = 0,
    val title: String = "",
    val notes: String = "",
    val category: String = "important",
    val time: String = "Now",
    val editEnabled: Boolean = false
)