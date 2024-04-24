package com.example.notedown.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
    colorList: List<Color>
){
    var expanded by remember {
        mutableStateOf(false)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(60.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f))
            .padding(12.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AnimatedVisibility(visible = expanded) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    for (i in colorList){
                        ColorCard(color = i)
                    }
                }
            }

            Icon(
                painter = painterResource(id = R.drawable.edit),
                contentDescription = stringResource(id = R.string.edit),
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .clickable(
                        onClick = { expanded = !expanded }
                    )
                    .padding(3.dp)
                    .alpha(1.0f)
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewBtnEditNote(){
    BtnEditNote(colorList = listOf(Color.Green, Color.Red, Color.Blue, Color.Magenta))
}