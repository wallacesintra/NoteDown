package com.example.notedown.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.example.notedown.data.local.NoteEntity
import com.example.notedown.presentation.components.Note
import com.example.notedown.presentation.models.NoteElementState
import com.example.notedown.presentation.viewmodels.NoteViewModel

@Composable
fun NoteScreen(
    noteId: Int,
    noteViewModel: NoteViewModel,
    navController: NavController
){
    val noteDetails by noteViewModel.getNotes(noteId).collectAsState(initial = NoteEntity())

    val noteElementState = NoteElementState(
        id = noteDetails.id,
        title = noteDetails.title,
        notes = noteDetails.note,
        category = noteDetails.category
    )

    Note(
        navController = navController,
        noteElementState = noteElementState
    )

}