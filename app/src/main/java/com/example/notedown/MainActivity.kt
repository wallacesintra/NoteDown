package com.example.notedown

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.notedown.presentation.components.Note
import com.example.notedown.presentation.components.NoteCard
import com.example.notedown.presentation.screens.Home
import com.example.notedown.presentation.theme.NoteDownTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteDownTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Row(
//                        modifier = Modifier.fillMaxSize()
//                    ) {
//                        NoteCard(
//                            title = "course designer udemy",
//                            notes = "Lorem23 uosgfo ouggfso ioggfs ougfa uogogafboa iphkhpaf iihphaf ugogfa uooga uogogaf uogogaf ougogaf ouogaf",
//                            date = "2 April, 2000"
//                        )
//                        NoteCard(
//                            title = "course designer udemy",
//                            notes = "Lorem23 uosgfo ouggfso ioggfs ougfa uogogafboa iphkhpaf iihphaf ugogfa uooga uogogaf uogogaf ougogaf ouogaf",
//                            date = "4 April, 2000"
//                        )
//
//
//                    }
//                    Greeting("Android")
//                    Note()
                    Home()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteDownTheme {
        Greeting("Android")
    }
}