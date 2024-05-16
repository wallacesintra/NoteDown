package com.example.notedown.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun BtnEditNote(
    onEditEvent: () -> Unit = {},
    onEnableEdit: () -> Unit = {},
    enableEditNote: Boolean = false
){

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
//            .background(Color.Transparent.copy(alpha = 0.1f))
            .background(Color.Transparent)
    ) {

        if (!enableEditNote){
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "edit note",
                tint = MaterialTheme.colorScheme.background,
                modifier = Modifier
                    .padding(10.dp)
                    .size(30.dp)
                    .clickable(
                        onClick = onEnableEdit
                    )

            )

        }else {
            Icon(
                imageVector =Icons.Default.Check,
                contentDescription = "save note",
                tint = MaterialTheme.colorScheme.background,
                modifier = Modifier
                    .padding(10.dp)
                    .size(30.dp)
                    .clickable(
                        onClick = onEditEvent
                    )
            )
        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewBtnEditNote(){
    BtnEditNote()
}