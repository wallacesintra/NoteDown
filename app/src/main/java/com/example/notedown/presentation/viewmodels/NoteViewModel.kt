package com.example.notedown.presentation.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
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
import com.example.notedown.presentation.util.formatDate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate

@OptIn(ExperimentalCoroutinesApi::class)
class NoteViewModel(
//    savedStateHandle: SavedStateHandle,
    private val noteDao: NoteDao
): ViewModel(){


    fun getNotes(noteId: Int): Flow<NoteEntity> {
        return noteDao.getNoteWithId(noteId)
    }

    fun deleteNoteById(noteId: Int){
        viewModelScope.launch(Dispatchers.IO) {
            noteDao.deleteNoteById(noteId)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun updateNote(newTitle: String, newNotes:String, id: Int, category:String){
        viewModelScope.launch(Dispatchers.IO) {

            val newNote = NoteEntity(
                title = newTitle,
                note = newNotes,
                id = id,
                category = category,
                time = formatDate(LocalDate.now())
            )
            noteDao.updateNote(newNote)
        }
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