package com.tjrushby.notelin.data

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [Note::class],
    exportSchema = false,
    version = 1
)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}
