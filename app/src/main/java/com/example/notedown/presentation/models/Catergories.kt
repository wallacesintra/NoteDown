package com.example.notedown.presentation.models

import androidx.compose.ui.graphics.Color

//val categories  = listOf("all", "important", "lecture notes", "shopping list")

data class Category(
    val type: String,
    val color: Color,
    var count: Int? = null,
    var active: Boolean = false,
    var noteType: Categories,
    var sortType: SortType,
)

enum class Categories{
    ALL,
    IMPORTANT,
    WORK,
    LECTURE_NOTE,
    RANDOM,
    SHOPPING_LIST
}

val allCategories: List<Category> = listOf(
    Category("all", Color(0xFFF6ECC9), noteType = Categories.ALL, sortType = SortType.ALL),
    Category("important", Color(0xFFEB7A53), noteType = Categories.IMPORTANT, sortType = SortType.IMPORTANT),
    Category("work", Color(0xFFF7D44C), noteType = Categories.WORK, sortType = SortType.WORK),
    Category("lecture notes", Color(0xFF98B7DB), noteType = Categories.LECTURE_NOTE, sortType = SortType.LECTURE_NOTE),
    Category("random", Color(0xFFFDF1F5), noteType = Categories.RANDOM, sortType = SortType.RANDOM),
    Category("shopping list", Color(0xFFA8D672), noteType = Categories.SHOPPING_LIST, sortType = SortType.SHOPPING_LIST),
)