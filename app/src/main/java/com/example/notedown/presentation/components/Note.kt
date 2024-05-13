package com.example.notedown.presentation.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.notedown.R
import com.example.notedown.presentation.models.NoteElementState
import com.example.notedown.presentation.models.NoteState
import com.example.notedown.presentation.util.colorMap
import com.example.notedown.presentation.viewmodels.NoteViewModel


@Composable
fun Note(
    navController: NavController,
    noteElementState: NoteElementState
){

    val color = colorMap[noteElementState.category] ?: Color(0xFFA8D672)

    val noteTitleValue = noteElementState.title


    var notes by remember {
        mutableStateOf(noteElementState.notes)
    }

    var noteTitle = noteElementState.title


    Card(
        colors = CardDefaults.cardColors(
            containerColor = color
        ),
        modifier = Modifier.padding(8.dp)
    ) {
        Box {
            Column {
                NoteTitleBar(
//                    noteTitle = "add note now then",
                    noteTitle = noteTitleValue ,
                    goBackEvent = { navController.popBackStack() },
                    iconColor = color
                )
//                Text(text = noteElementState.time)

                TextField(
                    value = notes,
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.start_writing),
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        cursorColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    textStyle = TextStyle(
                        color = MaterialTheme.colorScheme.onPrimary
                    ),
                    onValueChange = {
                        notes = it
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


            }
        }
    }





}