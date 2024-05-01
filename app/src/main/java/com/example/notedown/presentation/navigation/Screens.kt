package com.example.notedown.presentation.navigation

sealed class Screens(val route: String, val label: String){
    object Home: Screens(route = "Home", label = "Home Screen")
    object Note: Screens(route = "Note", label = "Note Screen")
}