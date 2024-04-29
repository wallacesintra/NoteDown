package com.example.notedown.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notedown.R
import com.example.notedown.data.local.NoteEntity
import com.example.notedown.presentation.components.BtnAddNote
import com.example.notedown.presentation.components.CategoryCard
import com.example.notedown.presentation.components.NoteCard
import com.example.notedown.presentation.events.HomeEvents
import com.example.notedown.presentation.models.NoteModel
import com.example.notedown.presentation.models.allCategories

@Composable
fun Home(
    noteList: List<NoteEntity>,
    onClick: (HomeEvents) -> Unit = {}
){
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
                        category = item.type,
                        isActive = item.active,
                        count = item.count ?: 0,
                        onEvent = { HomeEvents.SortNotes(item.sortType) }
                    )
                }

            }

            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 160.dp)
            ) {
                items(noteList) {item ->
                    NoteCard(
                        title =item.title,
                        notes =item.note,
                        category =item.category
                    )
                }
            }
        }

//        BtnAddNote( modifier = Modifier.align(Alignment.BottomEnd))
        Box(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.BottomEnd)
        ) {
            BtnAddNote()
        }
    }
}