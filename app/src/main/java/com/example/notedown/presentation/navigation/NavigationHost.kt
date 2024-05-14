package com.example.notedown.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.IntOffset
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
        startDestination = Screens.Home.route,
        enterTransition = { EnterTransition.None},
        exitTransition = { ExitTransition.None}
    ) {
        composable(
            Screens.Home.route,
        ) { Home(
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
            arguments =Screens.Note.navArguments,
            enterTransition = {
                slideIn(tween(500, easing = LinearOutSlowInEasing)){
                    IntOffset(100, -50)
                }
            },
            exitTransition = {
                slideOut(tween(400, easing = FastOutSlowInEasing)){
                    IntOffset(-100, 50)
                }
            }
            ) {
                val noteId = it.arguments?.getInt("noteId")
                if (noteId != null) {
                    NoteScreen(noteId = noteId, noteViewModel = noteViewModel, navController = navController)
                }
            }
    }
}