package com.example.notedown.presentation.viewmodels

import androidx.compose.runtime.MutableState
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
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class NoteViewModel(
//    savedStateHandle: SavedStateHandle,
    private val noteDao: NoteDao
): ViewModel(){

    var noteDetails = mutableStateOf(NoteEntity())
        private  set

    fun getNoteDetails(noteId: Int) {
        viewModelScope.launch {
            val details = noteDao.getNoteWithId(noteId).stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(2000),
                initialValue = NoteEntity()
            )

            noteDetails.value = NoteEntity(
                title = details.value.title,
                note = details.value.note,
                category = details.value.category,
                time = details.value.time,
                id = details.value.id
            )
        }
    }

//    fun getById(id: Int): MutableState<NoteEntity>{
//        getNoteDetails(id)
//        return noteDetails
//    }

    fun getNotes(noteId: Int): Flow<NoteEntity> {
        return noteDao.getNoteWithId(noteId)
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