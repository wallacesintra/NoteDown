package com.example.notedown.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.example.notedown.data.local.NoteEntity
import com.example.notedown.presentation.components.Note
import com.example.notedown.presentation.models.NoteElementState
import com.example.notedown.presentation.viewmodels.NoteViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

@Composable
fun NoteScreen(
    noteId: Int,
    noteViewModel: NoteViewModel,
    navController: NavController
){
    LaunchedEffect(key1 = noteId) {
        noteViewModel.getNoteDetails(noteId)
    }
    val noteDetails by noteViewModel.getNotes(noteId).collectAsState(initial = NoteEntity())
//    noteViewModel.getNoteDetails(noteId)
//    val noteDetails = noteViewModel.noteDetails
//    val noteDetails = noteViewModel.getById(noteId)

//    val noteElementState = noteDetails.value.time?.let {
//        NoteElementState(
//        id = noteDetails.value.id,
//        title = noteDetails.value.title,
//        notes = noteDetails.value.note,
//        category = noteDetails.value.category,
//        time = it
//    )
//    }

    val noteElementState = noteDetails.time?.let {
        NoteElementState(
        id = noteDetails.id,
        title = noteDetails.title,
        notes = noteDetails.note,
        category = noteDetails.category,
        time = it
    )
    }


    if (noteElementState != null) {
        Note(
            navController = navController,
            noteElementState = noteElementState
        )
    }

}