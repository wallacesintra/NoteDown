package com.example.notedown.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert
    fun insertNote(note: NoteEntity)

    @Delete
    fun deleteNote(note: NoteEntity)

    @Update
    fun updateNote(note: NoteEntity)

    @Query("SELECT * FROM noteentity ORDER BY id DESC")
    fun getAllNotes(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM noteentity WHERE  category = :category ORDER BY id DESC")
    fun sortNotes(category: String) : Flow<List<NoteEntity>>

    @Query("SELECT * FROM noteentity WHERE id = :noteId")
    fun getNoteWithId(noteId: Int): Flow<NoteEntity>

    @Query("SELECT * FROM noteentity WHERE title LIKE :query OR note LIKE :query")
    fun searchOnNotes(query: String): Flow<List<NoteEntity>>

}