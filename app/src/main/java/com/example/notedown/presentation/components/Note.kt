package com.example.notedown.presentation.components

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.notedown.R
import com.example.notedown.data.local.NoteEntity
import com.example.notedown.presentation.models.NoteElementState
import com.example.notedown.presentation.util.colorMap
import com.example.notedown.presentation.viewmodels.NoteViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Note(
    navController: NavController,
    noteElementState: NoteElementState,
    noteViewModel: NoteViewModel
){

    val color = colorMap[noteElementState.category] ?: Color(0xFFA8D672)

    var enableEditing by remember {
        mutableStateOf(true)
    }

    var noteTitle by remember {
        mutableStateOf(noteElementState.title)
    }

    var notes by remember {
        mutableStateOf(noteElementState.notes)
    }


    Card(
        colors = CardDefaults.cardColors(
            containerColor = color
        ),
        modifier = Modifier.padding(8.dp)
    ) {
        Box {
            Column {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "go back",
                            tint = MaterialTheme.colorScheme.background,
                            modifier = Modifier
                                .padding(8.dp)
                                .size(32.dp)
                                .clickable(
                                    onClick = { navController.popBackStack() }
                                )

                        )

                        TextField(
                            value = noteTitle,
                            enabled = enableEditing,
                            onValueChange = { noteTitle = it },
                            textStyle = TextStyle(
                                fontWeight = FontWeight.W700,
                                fontSize = 22.sp,
                                color = MaterialTheme.colorScheme.background
                            ),
                            placeholder = {
                                Text(
                                    text = "add note title",
                                    color = MaterialTheme.colorScheme.background
                                )
                            },
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = Color.Transparent,
                                focusedContainerColor = Color.Transparent,
                                cursorColor = MaterialTheme.colorScheme.onBackground,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                            ),
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(40.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(MaterialTheme.colorScheme.background)
                            .align(Alignment.CenterEnd)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "delete note",
                            tint = color,
                            modifier = Modifier
                                .clickable(
                                    onClick = {} //handle delete note
                                )
                                .padding(8.dp)

                        )
                    }

                }



                TextField(
                    value = notes,
                    enabled = enableEditing,
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.start_writing),
                            color = MaterialTheme.colorScheme.background
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        cursorColor = MaterialTheme.colorScheme.onPrimary,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    textStyle = TextStyle(
                        color = MaterialTheme.colorScheme.background,
                        fontSize = 18.sp
                    ),
                    onValueChange = {
                        notes = it
                        Log.d("note note:", notes)
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
            ) {
                BtnEditNote(onEditEvent = {
//                    enableEditing = !enableEditing
//
                    Log.d("edit title", noteTitle)
                    Log.d("edit note", notes)
                    noteElementState.id?.let {
                        noteViewModel.updateNote(
                            newTitle = noteTitle,
                            newNotes = notes,
                            id = it,
                            category = noteElementState.category
                        )
                    }
                })
            }
        }
    }





}