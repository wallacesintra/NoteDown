package com.example.notedown.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert
    fun insertNote(note: NoteEntity)

    @Delete
    fun deleteNote(note: NoteEntity)

    @Query("SELECT * FROM noteentity ORDER BY id DESC")
    fun displayAll(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM noteentity WHERE  category = :category")
    fun sortNotes(category: String) : Flow<List<NoteEntity>>

    @Query("SELECT * FROM noteentity WHERE id = :noteId")
    fun displayNoteWithId(noteId: Int): Flow<NoteEntity>

}