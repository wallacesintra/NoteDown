package com.example.notedown.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.notedown.presentation.screens.Home
import com.example.notedown.presentation.viewmodels.HomeViewModel

@Composable
fun Primary(){
    val homeViewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory)
    val state = homeViewModel.state
    val homeState by state.collectAsState()

    Column {
        Home(noteList = homeState.noteList)
    }
}