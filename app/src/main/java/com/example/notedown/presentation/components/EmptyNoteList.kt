package com.example.notedown.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notedown.R


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EmptyNoteList(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .fillMaxHeight(0.7f)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.add_note),
            contentDescription = "empty list",
            modifier = Modifier
                .padding(8.dp)
                .size(60.dp)
        )

        Text(
            text = "Click the add button to create a note",
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.W300,
            modifier = Modifier.padding(8.dp)
        )

    }
}