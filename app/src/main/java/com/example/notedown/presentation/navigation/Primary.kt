package com.example.notedown.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notedown.presentation.models.allCategories
import com.example.notedown.presentation.screens.Home
import com.example.notedown.presentation.viewmodels.HomeViewModel

@Composable
fun Primary(){
    val homeViewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory)
    val state = homeViewModel.state
    val homeState by state.collectAsState()
    val count = homeState.noteList.size

//    Column {
//        Home(
//            noteList = homeState.noteList,
//            categoryList = allCategories,
//            onSortCategoryClick = { homeViewModel.onEvent(it) },
//            onAddNoteClick = { homeViewModel.onEvent(it) },
//            onDeleteNoteEvent = {homeViewModel.onEvent(it)},
//            onEditNoteEvent = {},
//            count = count
//        )
//    }
}