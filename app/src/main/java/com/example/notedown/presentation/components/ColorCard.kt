package com.example.notedown.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ColorCard(
    color: Color
){
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(28.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(color)
            .padding(6.dp)
    )
}

@Preview
@Composable
fun PreviewColorCard(){
    ColorCard(color = Color.Red)
}