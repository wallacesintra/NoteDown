package com.example.notedown.presentation.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screens(val route: String, val navArguments: List<NamedNavArgument> = emptyList()){
    data object Home: Screens(route = "Home")
    data object Note: Screens(
        route = "Note/{noteId}",
        navArguments = listOf(navArgument("noteId"){
            type = NavType.IntType
        })
    ){
        fun createRoute(noteId: Int) = "Note/${noteId}"
    }
}