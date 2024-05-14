package com.example.notedown.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notedown.presentation.models.allCategories
import com.example.notedown.presentation.screens.Home
import com.example.notedown.presentation.screens.NoteScreen
import com.example.notedown.presentation.viewmodels.HomeViewModel
import com.example.notedown.presentation.viewmodels.NoteViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationHost(){
    val navController = rememberNavController()

    //Home viewmodel
    val homeViewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory)
    val state = homeViewModel.state
    val homeUiState by state.collectAsState()
    val count = homeUiState.noteList.size


    //Note viewmodel
    val noteViewModel: NoteViewModel = viewModel(factory = NoteViewModel.Factory)

    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ) {
        composable(Screens.Home.route) { Home(
            navController = navController,
            noteList = homeUiState.noteList,
            categoryList = allCategories,
            onSortCategoryClick = { homeViewModel.onEvent(it) },
            onAddNoteClick = { homeViewModel.onEvent(it) },
            onDeleteNoteEvent = {homeViewModel.onEvent(it)},
            onEditNoteCard = {
                it.id?.let { noteElementId ->
                    navController.navigate(
                        Screens.Note.createRoute(
                            noteId = noteElementId
                        )
                    )
                }
            },
            count = count
        )}

        composable(
            Screens.Note.route,
            arguments =Screens.Note.navArguments
            ) {
                val noteId = it.arguments?.getInt("noteId")
                if (noteId != null) {
                    NoteScreen(noteId = noteId, noteViewModel = noteViewModel, navController = navController)
                }
            }
    }
}