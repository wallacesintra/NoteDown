package com.example.notedown.presentation.util

import android.content.Context
import android.content.Intent

fun Context.shareNote(title: String, note: String){
    val sendIntent = Intent(
        Intent.ACTION_SEND
    ).apply {
        putExtra(Intent.EXTRA_TEXT, "${title}\n $note")
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(
        sendIntent, "Share Note"
    )
    startActivity(shareIntent)
}