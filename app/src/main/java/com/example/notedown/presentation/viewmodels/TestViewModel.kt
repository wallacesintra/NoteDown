package com.example.notedown.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notedown.presentation.events.HomeEvents
import com.example.notedown.presentation.models.HomeState
import com.example.notedown.presentation.models.SortType
import com.example.notedown.presentation.screens.HomeViewState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TestViewModel: ViewModel() {
    private val _sortType = MutableStateFlow(SortType.ALL)


    var homeState by mutableStateOf(HomeViewState())


    fun onEvent(event: HomeEvents){
        when (event){
            is HomeEvents.SortNotes -> {
                _sortType.value = event.sortType
            }

            is HomeEvents.AddNote -> TODO()
            is HomeEvents.DeleteNote -> { TODO()
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

}