package com.example.notedown.presentation.components

import android.graphics.drawable.shapes.Shape
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.notedown.R


@Composable
fun NoteCard(
    title: String,
    notes: String,
    date: String,
    cardColor: Color
){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = cardColor
        ),
        modifier = Modifier
            .width(170.dp)
            .height(200.dp)
            .padding(8.dp)
    ) {
        var editable by remember{
            mutableStateOf(false)
        }
//        val editColor:Color by animateColorAsState( if (editable) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.background,
//            label = "edit color"
//        )
        Box(
            modifier = Modifier.padding(8.dp)
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.BottomEnd)
            ){
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.background,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W700,
                    modifier = Modifier.padding(vertical = 3.dp)
                )
                Text(
                    text = notes,
                    overflow = TextOverflow.Ellipsis,
                    maxLines =5,
                    fontWeight = FontWeight.W300,
                    style = TextStyle(
                        brush = Brush.verticalGradient(
                            colors = listOf(MaterialTheme.colorScheme.background, MaterialTheme.colorScheme.background,Color.Transparent)
                        )
                    ),
                    fontSize = 14.sp,
                )
            }
            Text(
                text = date,
                fontWeight = FontWeight.W500,
                color = MaterialTheme.colorScheme.background,
                modifier = Modifier
                    .align(Alignment.BottomStart)
            )
            Card(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp
                ),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
            ) {
                Column(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .padding(4.dp)
                ) {
                    AnimatedVisibility(
                        visible = editable
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = stringResource(id = R.string.delete),
                            tint = Color.Red,
                            modifier = Modifier
                                .padding(bottom = 20.dp)
                        )
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.edit),
                        contentDescription = stringResource(id = R.string.edit),
                        modifier = Modifier.clickable(
                            onClick = { editable = !editable}
                        ),
                        tint = cardColor
                    )
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun NoteCardPreview(){
    NoteCard(
        title = "course designer udemy",
        notes = "Lorem23 uosgfo ouggfso ioggfs ougfa uogogafboa iphkhpaf iihphaf ugogfa uooga uogogaf uogogaf ougogaf ouogaf",
        date = "2 April, 2000",
        cardColor = Color(0xFFF7D44C)
    )

}


