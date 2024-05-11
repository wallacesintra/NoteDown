package com.example.notedown.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.notedown.NoteApp
import com.example.notedown.data.local.NoteDao
import com.example.notedown.data.local.NoteEntity
import com.example.notedown.presentation.models.NoteElementState
import com.example.notedown.presentation.models.NoteState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

@OptIn(ExperimentalCoroutinesApi::class)
class NoteViewModel(
//    savedStateHandle: SavedStateHandle,
    private val noteDao: NoteDao
): ViewModel(){
    var noteState: NoteState by mutableStateOf(NoteState.Loading)
        private set

//    val noteId: Int = checkNotNull(savedStateHandle["noteId"])
    var noteId: Int?= 1
//    var noteId: Int? = savedStateHandle.get<Int>(NOTE_ID)

    val note = noteId?.let { noteDao.getNoteWithId(it).stateIn(viewModelScope, SharingStarted.WhileSubscribed(), NoteEntity()) }

    init {
        noteId?.let { getNoteDetails(it) }
    }

    fun getNotes(noteId: Int): Flow<NoteEntity> {
        return noteDao.getNoteWithId(noteId)
    }

    private fun getNoteDetails(id: Int): NoteState{
        val note = noteDao.getNoteWithId(id).stateIn(viewModelScope, SharingStarted.WhileSubscribed(), NoteEntity())

        noteState = NoteState.Success(
            NoteElementState(
                id = note.value.id,
                title = note.value.title,
                notes = note.value.note,
                category = note.value.category,
            )
        )
        return noteState
    }

    companion object {

        private const val NOTE_ID = "note_id"

        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as NoteApp)
                val noteDao = application.container.noteDatabase.noteDao
//                val savedStateHandle = this.get<SavedStateHandle>(NOTE_ID)
                NoteViewModel(noteDao)
            }
        }
    }

//    companion object {
//        private const val NOTE_ID = "note_id"
//
//        val Factory: ViewModelProvider.Factory = viewModelFactory {
//            initializer {
//                val application = this[APPLICATION_KEY] as NoteApp
//                val noteDao = application.container.noteDatabase.noteDao
//                val savedStateHandle = this.get<SavedStateHandle>(NOTE_ID)
//                if (savedStateHandle != null) {
//                    NoteViewModel(savedStateHandle, noteDao)
//                } else {
//                    // Handle the case where savedStateHandle is null
//                    // For example, you could throw an exception or return a default ViewModel
//                    throw IllegalStateException("SavedStateHandle is null")
//                }
//            }
//        }
//    }
}