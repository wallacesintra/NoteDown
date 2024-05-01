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
import com.example.notedown.presentation.models.NoteModel
import com.example.notedown.presentation.navigation.NavigationHost
import com.example.notedown.presentation.navigation.Primary
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

                    val noteList = listOf(
                        NoteModel("read the note", notes = "iugiowfiiog ouguogwf oogwg ouuogw ouogwgf ouogogwg oogow ouhougwg ouogw gougogw goougw ", "important"),
                        NoteModel("read the note", notes = "iugiowfiiog ouguogwf oogwg ouuogw ouogwgf ouogogwg oogow ouhougwg ouogw gougogw goougw ", "random"),
                        NoteModel("read the note", notes = "iugiowfiiog ouguogwf oogwg ouuogw ouogwgf ouogogwg oogow ouhougwg ouogw gougogw goougw ", "lecture notes"),
                        NoteModel("read the note", notes = "iugiowfiiog ouguogwf oogwg ouuogw ouogwgf ouogogwg oogow ouhougwg ouogw gougogw goougw ", "important"),
                        NoteModel("read the note", notes = "iugiowfiiog ouguogwf oogwg ouuogw ouogwgf ouogogwg oogow ouhougwg ouogw gougogw goougw ", "shopping list"),
                        NoteModel("read the note", notes = "iugiowfiiog ouguogwf oogwg ouuogw ouogwgf ouogogwg oogow ouhougwg ouogw gougogw goougw ", "random"),
                        NoteModel("read the note", notes = "iugiowfiiog ouguogwf oogwg ouuogw ouogwgf ouogogwg oogow ouhougwg ouogw gougogw goougw ", "lecture notes"),
                        NoteModel("read the note", notes = "iugiowfiiog ouguogwf oogwg ouuogw ouogwgf ouogogwg oogow ouhougwg ouogw gougogw goougw ", "work"),
                        NoteModel("read the note", notes = "iugiowfiiog ouguogwf oogwg ouuogw ouogwgf ouogogwg oogow ouhougwg ouogw gougogw goougw ", "lecture notes"),
                        NoteModel("read the note", notes = "iugiowfiiog ouguogwf oogwg ouuogw ouogwgf ouogogwg oogow ouhougwg ouogw gougogw goougw ", "work"),
                        NoteModel("read the note", notes = "iugiowfiiog ouguogwf oogwg ouuogw ouogwgf ouogogwg oogow ouhougwg ouogw gougogw goougw ", "random"),


                    )
                    NavigationHost()
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