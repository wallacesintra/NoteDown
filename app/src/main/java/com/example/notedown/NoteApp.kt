package com.example.notedown

import android.app.Application
import com.example.notedown.data.AppContainer
import com.example.notedown.data.DefaultContainer

class NoteApp: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultContainer(this)
    }
}