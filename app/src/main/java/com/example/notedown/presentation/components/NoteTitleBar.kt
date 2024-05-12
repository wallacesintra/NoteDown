package com.example.notedown.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



//@Preview
@Composable
fun NoteTitleBar(
    noteTitle: String,
    goBackEvent: () -> Unit = {},
    onDeleteNoteEvent:() -> Unit = {},
    iconColor: Color,
    enableEdit: Boolean = true
){

    //note title
    var title by remember {
        mutableStateOf(noteTitle)
    }

    Box(
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "go back",
                modifier = Modifier
                    .padding(8.dp)
                    .size(32.dp)
                    .clickable(
                        onClick = goBackEvent
                    )
            )

            TextField(
                value = title,
                enabled = enableEdit,
                onValueChange = { title = it },
                textStyle = TextStyle(
                    fontWeight = FontWeight.W700,
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onBackground
                ),
                placeholder = {
                              Text(text = "Add Note title")
                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    cursorColor = MaterialTheme.colorScheme.onBackground,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
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
                tint = iconColor,
                modifier = Modifier
                    .clickable(
                        onClick = onDeleteNoteEvent
                    )
                    .padding(8.dp)

            )
        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewNoteTitleBar(){
//    NoteTitleBar(noteTitle = "")
}