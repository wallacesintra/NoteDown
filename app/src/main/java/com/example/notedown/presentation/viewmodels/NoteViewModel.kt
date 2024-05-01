package com.example.notedown.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.notedown.NoteApp
import com.example.notedown.data.local.NoteDao
import com.example.notedown.data.local.NoteEntity
import com.example.notedown.presentation.models.NoteState
import com.example.notedown.presentation.models.NoteElementState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn

@OptIn(ExperimentalCoroutinesApi::class)
class NoteViewModel(
    private val noteDao: NoteDao
): ViewModel(){
//    var noteState by mutableStateOf(NoteState())
    private val _noteState = MutableStateFlow(NoteState.Success(
        noteUiState = NoteElementState()
    ))
    var noteId by mutableIntStateOf(1)

    private val _note = _noteState
        .flatMapLatest { _ ->
            noteDao.displayNoteWithId(noteId)
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), NoteEntity())

    val noteState = combine(_noteState, _note) { noteState, note ->
        noteState.copy(
            noteUiState = NoteElementState(
                id = note.id,
                title = note.title,
                notes = note.note,
                category = note.category
            )
        )
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as NoteApp)
                val noteDao = application.container.noteDatabase.noteDao
                NoteViewModel(noteDao)
            }
        }
    }

}