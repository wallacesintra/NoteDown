package com.example.notedown.presentation.models

import androidx.compose.ui.graphics.Color
import com.example.notedown.presentation.events.HomeEvents

//val categories  = listOf("all", "important", "lecture notes", "shopping list")

data class Category(
    val type: String,
    val color: Color,
    var count: Int? = null,
    var active: Boolean = false,
    var noteType: Categories,
    var sortType: SortType,

    //
    var onAddNoteEvent: HomeEvents? = null,

    var onSortNotesEvent: HomeEvents
)

enum class Categories{
    ALL,
    IMPORTANT,
    WORK,
    LECTURE_NOTE,
    RANDOM,
    GOALS
}




val allCategories: List<Category> = listOf(Category(
        "all",
//        Color(0xFFF6ECC9),
        Color(0xFF9370DB),
        active = true,
        noteType = Categories.ALL,
        sortType = SortType.ALL,
        onSortNotesEvent = HomeEvents.SortNotes(SortType.ALL)
    ),
    Category(
        "important",
        Color(0xFFEB7A53),
        noteType = Categories.IMPORTANT,
        sortType = SortType.IMPORTANT,
        onAddNoteEvent = HomeEvents.AddNote("important"),
        onSortNotesEvent = HomeEvents.SortNotes(SortType.IMPORTANT)
    ),
    Category(
        "work",
        Color(0xFFF7D44C),
        noteType = Categories.WORK,
        sortType = SortType.WORK,
        onAddNoteEvent = HomeEvents.AddNote("work"),
        onSortNotesEvent = HomeEvents.SortNotes(SortType.WORK)
    ),
    Category(
        "lecture notes",
        Color(0xFF98B7DB),
        noteType = Categories.LECTURE_NOTE,
        sortType = SortType.LECTURE_NOTE,
        onAddNoteEvent = HomeEvents.AddNote("lecture notes"),
        onSortNotesEvent = HomeEvents.SortNotes(SortType.LECTURE_NOTE)
    ),
    Category(
        "random",
        Color(0xFFFDF1F5),
        noteType = Categories.RANDOM,
        sortType = SortType.RANDOM,
        onAddNoteEvent = HomeEvents.AddNote("random"),
        onSortNotesEvent = HomeEvents.SortNotes(SortType.RANDOM)
    ),
    Category(
        "goals",
        Color(0xFFA8D672),
        noteType = Categories.GOALS,
        sortType = SortType.GOAL,
        onAddNoteEvent = HomeEvents.AddNote("shopping list"),
        onSortNotesEvent = HomeEvents.SortNotes(SortType.GOAL)
    ),)