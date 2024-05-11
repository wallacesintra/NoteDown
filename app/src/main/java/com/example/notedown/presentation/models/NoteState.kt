package com.example.notedown.presentation.models

sealed interface NoteState {
    data class Success(val noteUiState: NoteElementState): NoteState

    object Loading: NoteState

    object Error: NoteState
}

