package com.example.notedown.presentation.components

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


@Composable
fun Note(
    navController: NavController
){
    var noteTitle by remember {
        mutableStateOf("")
    }

    var notes by remember {
        mutableStateOf("")
    }
    val maxLength = 25
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier.padding(8.dp)
    ) {
        Box {
            Column {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "go back",
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier
                                .padding(4.dp)
                                .size(30.dp)
                                .clickable(
                                    onClick = {navController.popBackStack()}
                                )
                        )

                        TextField(
                            value = noteTitle,
                            textStyle = TextStyle(
                                fontWeight = FontWeight.W700,
                                fontSize = 20.sp,
                                color = MaterialTheme.colorScheme.onPrimary
                            ),
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = Color.Transparent,
                                focusedContainerColor = Color.Transparent,
                                cursorColor = MaterialTheme.colorScheme.onPrimary
                            ),
                            maxLines = 1,
                            placeholder = {
                                Text(
                                    text = stringResource(id = R.string.untitled),
                                    color = MaterialTheme.colorScheme.onPrimary
                                )
                            },
                            onValueChange = {
                                if (it.length <= maxLength) {
                                    noteTitle = it
                                }
                            }
                        )
                    }

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .padding(8.dp)
                            .defaultMinSize(minHeight = 34.dp)
//                            .size(34.dp)
                            .clip(RoundedCornerShape(17.dp))
                            .background(MaterialTheme.colorScheme.background)

                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "delete note",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier

                        )
                    }
                }

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
                BtnEditNote(colorList = listOf(Color.Green, Color.Red, Color.Blue, Color.Magenta))

            }
        }
    }
}