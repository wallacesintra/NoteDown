package com.example.notedown.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notedown.R
import com.example.notedown.presentation.components.CategoryCard
import com.example.notedown.presentation.components.NoteCard
import com.example.notedown.presentation.models.allCategories
import com.example.notedown.presentation.models.categories

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Home(){
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
        ){
            items(allCategories){ item ->
                CategoryCard(category = item.type, cardColor = item.color, isActive = item.active, count = item.count?:0 )
            }

        }

        Row {
            NoteCard(
                title = "course designer udemy",
                notes = "Lorem23 uosgfo ouggfso ioggfs ougfa uogogafboa iphkhpaf iihphaf ugogfa uooga uogogaf uogogaf ougogaf ouogaf",
                date = "2 April, 2000",
                cardColor = Color(0xFFF7D44C)
            )
            NoteCard(
                title = "course designer udemy",
                notes = "Lorem23 uosgfo ouggfso ioggfs ougfa uogogafboa iphkhpaf iihphaf ugogfa uooga uogogaf uogogaf ougogaf ouogaf",
                date = "4 April, 2000",
                cardColor = Color(0xFFEB7A53)
            )
        }
    }
}