package com.example.notedown.presentation.models

import androidx.compose.ui.graphics.Color

val categories  = listOf("all", "important", "lecture notes", "shopping list")

data class Category(
    val type: String,
    val color: Color,
    var count: Int? = null,
    var active: Boolean = false
)



val allCategories: List<Category> = listOf(
    Category("all", Color(0xFFF6ECC9)),
    Category("important", Color(0xFFEB7A53)),
    Category("work", Color(0xFFF7D44C)),
    Category("lecture notes", Color(0xFF98B7DB)),
    Category("random", Color(0xFFFDF1F5)),
    Category("shopping list", Color(0xFFA8D672)),
)