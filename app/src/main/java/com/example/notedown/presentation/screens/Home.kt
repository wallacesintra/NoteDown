package com.example.notedown.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.notedown.R
import com.example.notedown.data.local.NoteEntity
import com.example.notedown.presentation.components.BtnAddNote
import com.example.notedown.presentation.components.CategoryCard
import com.example.notedown.presentation.components.EmptyNoteList
import com.example.notedown.presentation.components.NoteCard
import com.example.notedown.presentation.events.HomeEvents
import com.example.notedown.presentation.models.Category
import com.example.notedown.presentation.models.allCategories

@Composable
fun Home(
    navController: NavController,
    noteList: List<NoteEntity>,
    categoryList: List<Category>,
    onSortCategoryClick: (HomeEvents) -> Unit = {},
    onAddNoteClick: (HomeEvents) -> Unit = {},
    onEditNoteCard: (NoteEntity) -> Unit = {},
    onDeleteNoteEvent: (HomeEvents) -> Unit,
    count: Int?
){

    var activeCategory by remember { mutableStateOf(categoryList.first()) }

    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(8.dp)
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.labelLarge,
                fontSize = 45.sp,
                modifier = Modifier.padding(vertical = 10.dp)
            )

            LazyRow(
                modifier = Modifier.padding(vertical = 20.dp)
            ) {
                items(allCategories) { item ->
                    CategoryCard(
                        category = item,
                        isCategoryActive = item == activeCategory,
                        onSortCategoryClick = {
                            onSortCategoryClick(item.onSortNotesEvent)
                            activeCategory = item
                        },
                        count = count
                    )
                }
            }

            if (noteList.isEmpty()){
                EmptyNoteList()
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 160.dp)
                ) {
                    items(noteList) {item ->
                        NoteCard(
                            navController = navController,
                            noteElement = item,
                            goToNoteScreen = onEditNoteCard,
                            onDeleteNoteEvent = onDeleteNoteEvent,
                        )
                    }
                }
            }

        }

        // create new note button
        Box(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.BottomEnd)
        ) {
            BtnAddNote(
                categoryList = categoryList,
                onClickAddNote = onAddNoteClick
            )
        }
    }
}