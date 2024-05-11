package com.example.notedown.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.notedown.data.local.NoteEntity
import com.example.notedown.presentation.models.NoteElementState
import com.example.notedown.presentation.models.NoteState
import com.example.notedown.presentation.viewmodels.NoteViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun NoteElement(
    noteElementState: NoteElementState
){
    Column {
        Text(text = noteElementState.title )
        Text(text = noteElementState.notes)
        Text(text = noteElementState.category)
        Text(text = noteElementState.id.toString())
    }
}

@Composable
fun NoteContainer(
    noteId: Int,
    noteViewModel: NoteViewModel
){
//    val notes by (noteViewModel.note ?: emptyFlow()).collectAsState(NoteEntity())

    val notes by noteViewModel.getNotes(noteId).collectAsState(initial = NoteEntity())

    val noteElementState= NoteElementState(
        id = notes.id,
        title = notes.title,
        notes = notes.note,
        category = notes.category
    )

    NoteElement(noteElementState = noteElementState)

}