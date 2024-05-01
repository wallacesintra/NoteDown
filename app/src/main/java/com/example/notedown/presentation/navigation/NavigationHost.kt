package com.example.notedown.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notedown.presentation.components.Note
import com.example.notedown.presentation.models.allCategories
import com.example.notedown.presentation.screens.Home
import com.example.notedown.presentation.viewmodels.HomeViewModel

@Composable
fun NavigationHost(){
    val navController = rememberNavController()

    val homeViewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory)
    val state = homeViewModel.state
    val homeState by state.collectAsState()
    val count = homeState.noteList.size

    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ) {
        composable(Screens.Home.route) { Home(
            navController = navController,
            noteList = homeState.noteList,
            categoryList = allCategories,
            onSortCategoryClick = { homeViewModel.onEvent(it) },
            onAddNoteClick = { homeViewModel.onEvent(it) },
            onDeleteNoteEvent = {homeViewModel.onEvent(it)},
            onEditNoteEvent = {},
            count = count
        )}

        composable(Screens.Note.route) { Note(navController = navController)}
    }
}