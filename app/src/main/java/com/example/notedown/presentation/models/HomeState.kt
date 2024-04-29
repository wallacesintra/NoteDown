package com.example.notedown.presentation.models

import com.example.notedown.data.local.NoteEntity

data class HomeState (
    val sortType: SortType = SortType.ALL,
    val noteTitle: String = "",
    val notes: String = "",
    val noteList: List<NoteEntity> = emptyList()
)