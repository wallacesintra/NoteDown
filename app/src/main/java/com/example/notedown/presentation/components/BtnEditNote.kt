package com.example.notedown.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notedown.R


@Composable
fun BtnEditNote(
    onEditEvent: () -> Unit = {}
){
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .background(Color.Transparent.copy(alpha = 0.1f))
            .clickable(
                onClick = onEditEvent
            )
    ) {

        Icon(
            imageVector = Icons.Default.Edit,
            contentDescription = "edit note",
            tint = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .padding(10.dp)
                .size(30.dp)

        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewBtnEditNote(){
    BtnEditNote()
}