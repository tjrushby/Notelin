package com.tjrushby.notelin.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun getAllNotes(): LiveData<List<Note>>

    @Insert
    suspend fun saveNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("DELETE FROM notes")
    fun deleteAllNotes()
}
