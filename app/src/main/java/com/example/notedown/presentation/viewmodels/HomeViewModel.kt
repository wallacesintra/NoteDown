package com.example.notedown.presentation.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
import com.example.notedown.presentation.events.HomeEvents
import com.example.notedown.presentation.models.HomeState
import com.example.notedown.presentation.models.SortType
import com.example.notedown.presentation.screens.HomeViewState
import com.example.notedown.presentation.util.formatDate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate

class HomeViewModel(
    private val noteDao: NoteDao
) : ViewModel(){
     private val _sortType = MutableStateFlow(SortType.ALL)


    var homeState by mutableStateOf(HomeViewState())
        private set

    @OptIn(ExperimentalCoroutinesApi::class)
    private val _notes = _sortType
        .flatMapLatest { sortType ->
            when (sortType) {
                SortType.ALL -> noteDao.getAllNotes()
                SortType.IMPORTANT -> noteDao.sortNotes("important")
                SortType.WORK -> noteDao.sortNotes("work")
                SortType.LECTURE_NOTE -> noteDao.sortNotes("lecture notes")
                SortType.RANDOM -> noteDao.sortNotes("random")
                SortType.GOAL -> noteDao.sortNotes("shopping list")
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _state = MutableStateFlow(HomeState())

    val state = combine(_state, _sortType, _notes) { state, sortType, notes ->
        state.copy(
            noteList = notes,
            sortType = sortType
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), HomeState())

    @RequiresApi(Build.VERSION_CODES.O)
    private fun addNewNote(type: String){
        val title: String = ""
        val notes: String = ""
        val currentTime = LocalDate.now()

        val noteElement = NoteEntity(
            title = title,
            note = notes,
            category = type,
            time = formatDate(currentTime)
        )

        viewModelScope.launch(Dispatchers.IO) {
            noteDao.insertNote(noteElement)
        }

    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun onEvent(event: HomeEvents){
        when (event){
            is HomeEvents.SortNotes -> {
                _sortType.value = event.sortType
            }

            is HomeEvents.AddNote -> addNewNote(event.type)
            is HomeEvents.DeleteNote -> {
                viewModelScope.launch(Dispatchers.IO) {
                    noteDao.deleteNote(event.note)
                }
            }
            is HomeEvents.EditNote -> {
                TODO()
            }


            is HomeEvents.OnUpdateMyData -> {
                homeState = homeState.copy(
                    myDataInViewState = event.myDataInEvent
                )
            }
        }
    }

    companion object {
        val Factory :ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as NoteApp)
                val noteDao = application.container.noteDatabase.noteDao
                HomeViewModel(noteDao)
            }
        }
    }
}
