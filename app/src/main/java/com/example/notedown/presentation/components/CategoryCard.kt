package com.example.notedown.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notedown.presentation.events.HomeEvents
import com.example.notedown.presentation.models.Category
import com.example.notedown.presentation.util.colorMap


@Composable
fun CategoryCard(
    onSortCategoryClick: (HomeEvents) -> Unit = {},
    category: Category,
    isCategoryActive: Boolean,
    count: Int?
//    modifier: Modifier = Modifier
){
     val cardColor = colorMap[category.type] ?: Color(0xFFA8D672)

    var active by remember {
        mutableStateOf(isCategoryActive)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(5.dp)
            .height(40.dp)
            .clip(RoundedCornerShape(30.dp))
            .border(2.dp, cardColor, RoundedCornerShape(30.dp))
            .padding(horizontal = 10.dp)
            .clickable(
                onClick = {
                    active = !active
                    if (active) {
                        onSortCategoryClick(category.onSortNotesEvent)
                    }
                }
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = category.type,
                fontSize = 18.sp,
            )

            AnimatedVisibility(visible = active) {
                Text(
                    text = count.toString(),
                    color = cardColor,
                    modifier = Modifier
                        .padding(9.dp)
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewCategoryCard(){
//    CategoryCard(category = "all", true, {}, 7)
}