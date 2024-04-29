package com.example.notedown.presentation.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.notedown.presentation.events.HomeEvents
import com.example.notedown.presentation.screens.HomeViewState
import com.example.notedown.presentation.viewmodels.TestViewModel

class TestUpdateScreenActivity: ComponentActivity() {

    val homeViewModel: TestViewModel by viewModels<TestViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent { 
            TestUpdateScreen(
                homeState = homeViewModel.homeState,
                onUpdateMyData = {dataUpdateValue ->
                    homeViewModel.onEvent(HomeEvents.OnUpdateMyData(dataUpdateValue))
                }
            )
        }
    }
}

@Composable
fun TestUpdateScreen(
    homeState: HomeViewState,
    onUpdateMyData: (String) -> Unit
){
    var counter by remember{
        mutableStateOf(1)
    }

    var thisMyData = "wow"

    Column {
        Button(onClick = {
            onUpdateMyData(thisMyData)
            counter ++
        }) {
            Text(text = "Click me" + homeState.myDataInViewState + counter)
        }

//        Text(text = homeState)
    }
}

@Preview
@Composable
fun TestUpdateScreenPreview(){
//    TestUpdateScreen()
}