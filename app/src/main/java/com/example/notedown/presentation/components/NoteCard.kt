package com.example.notedown.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.notedown.R
import com.example.notedown.data.local.NoteEntity
import com.example.notedown.presentation.events.HomeEvents
import com.example.notedown.presentation.navigation.Screens
import com.example.notedown.presentation.util.colorMap


@Composable
fun NoteCard(
    navController: NavController,
    noteElement: NoteEntity,
//    date: String = "12 Apr, 2024",
    onEditNoteEvent: (NoteEntity) -> Unit = {},
    onDeleteNoteEvent: (HomeEvents) -> Unit = {},
){

    val color = colorMap[noteElement.category] ?: Color(0xFFA8D672)
    var expanded by remember{
        mutableStateOf(false)
    }


    Card(
        colors = CardDefaults.cardColors(
            containerColor = color
        ),
        modifier = Modifier
            .width(170.dp)
            .height(200.dp)
            .padding(8.dp)
            .clickable(
                onClick = {
                    onEditNoteEvent(noteElement)
                }
            )
    ) {


        Box(
            modifier = Modifier.padding(8.dp)
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.BottomEnd)
            ){
                Text(
                    text = noteElement.title,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W700,
                    modifier = Modifier.padding(vertical = 3.dp)
                )
                Text(
                    text = noteElement.note,
                    overflow = TextOverflow.Ellipsis,
                    maxLines =5,
                    fontWeight = FontWeight.W300,
                    style = TextStyle(
                        brush = Brush.verticalGradient(
                            colors = listOf(MaterialTheme.colorScheme.onBackground, MaterialTheme.colorScheme.onBackground,Color.Transparent)
                        )
                    ),
                    fontSize = 14.sp,
                )
            }
            noteElement.time?.let {
                Text(
                    text = it,
                    fontWeight = FontWeight.W500,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                )
            }
            Card(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp
                ),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .clickable(
                        onClick = { expanded = !expanded }
                    )
            ) {
                Column(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .padding(4.dp)
                ) {
                    AnimatedVisibility(
                        visible = expanded
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = stringResource(id = R.string.delete),
                            tint = Color.Red,
                            modifier = Modifier
                                .padding(bottom = 20.dp)
                                .clickable(
                                    onClick = {
                                        onDeleteNoteEvent(HomeEvents.DeleteNote(noteElement))
                                        expanded = !expanded

                                    }
                                )
                        )
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.edit),
                        contentDescription = stringResource(id = R.string.edit),
                        modifier = Modifier.clickable(
                            onClick = {
                                expanded = !expanded

//                                if (expanded){
//                                    navController.navigate("${Screens.Note.route}/${noteElement.id}")
//                                }
                            }
                        ),
                        tint = color
                    )
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun NoteCardPreview(){
    
}


