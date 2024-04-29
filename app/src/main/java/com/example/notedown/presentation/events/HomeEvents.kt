package com.example.notedown.presentation.events

import com.example.notedown.data.local.NoteEntity
import com.example.notedown.presentation.models.NoteModel
import com.example.notedown.presentation.models.SortType

sealed class HomeEvents  {
    data class SortNotes(val sortType: SortType) : HomeEvents()
    data class DeleteNote(val note: NoteEntity): HomeEvents()
    data class AddNote(val type: String): HomeEvents()
    data class EditNote(val note: NoteEntity): HomeEvents()


    //test
    data class OnUpdateMyData(var myDataInEvent: String): HomeEvents()
}