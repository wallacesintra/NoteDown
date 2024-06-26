package com.example.notedown.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notedown.R
import com.example.notedown.presentation.events.HomeEvents
import com.example.notedown.presentation.models.Category
import com.example.notedown.presentation.util.colorMap


@Composable
fun BtnAddNote(
    modifier: Modifier = Modifier,
    categoryList: List<Category>,
    onClickAddNote: (HomeEvents) -> Unit = {}
){

    var expanded by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .background(MaterialTheme.colorScheme.background)
            .border(2.dp, MaterialTheme.colorScheme.onBackground, RoundedCornerShape(30.dp))
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioHighBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        AnimatedVisibility(visible = expanded) {
            Column {
                for (i in categoryList.drop(1)){
                    AddCategoryCard(
                        category = i,
                        onClickAddNote = onClickAddNote
                    )
                }
            }
            
        }


        Box() {
            Icon(
                painter = painterResource(id = if (expanded) R.drawable.close else R.drawable.add),
                contentDescription = "add note",
                modifier = Modifier
                    .clickable(
                        onClick = { expanded = !expanded }
                    )
                    .padding(3.dp)
            )
        }
    }
}

@Composable
fun AddCategoryCard(
    category: Category,
    onClickAddNote: (HomeEvents) -> Unit
){

    val cardColor = colorMap[category.type] ?: Color(0xFFA8D672)

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(5.dp)
            .height(40.dp)
            .clip(RoundedCornerShape(30.dp))
            .border(2.dp, cardColor, RoundedCornerShape(30.dp))
            .padding(horizontal = 10.dp)
            .clickable(
                onClick = { category.onAddNoteEvent?.let { onClickAddNote(it) } }
            )
    ) {
        Text(
            text = category.type,
            fontSize = 18.sp,
        )
    }
}