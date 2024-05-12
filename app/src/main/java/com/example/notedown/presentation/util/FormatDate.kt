package com.example.notedown.presentation.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun formatDate(localDate: LocalDate): String? {
    val date = LocalDate.parse(localDate.toString())
    val formatter = DateTimeFormatter.ofPattern("dd MMM, yy")
    return date.format(formatter)
}