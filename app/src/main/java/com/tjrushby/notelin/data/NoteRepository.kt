package com.tjrushby.notelin.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


interface NoteRepository {
    fun getAllNotes(): LiveData<List<Note>>

    fun saveNote(note: Note): Job

    fun updateNote(note: Note): Job

    fun deleteNote(note: Note): Job

    fun deleteAllNotes(): Job
}

class NoteRepositoryImpl(private val noteDao : NoteDao) : NoteRepository{

    private val notesList: LiveData<List<Note>> = noteDao.getAllNotes()

    override fun getAllNotes(): LiveData<List<Note>> {
        return notesList
    }

    override fun saveNote(note: Note) = runBlocking {
        launch(Dispatchers.IO) {
            noteDao.saveNote(note)
        }
    }

    override fun updateNote(note: Note) = runBlocking {
        launch(Dispatchers.IO) {
            noteDao.updateNote(note)
        }
    }

    override fun deleteNote(note: Note) = runBlocking {
        launch(Dispatchers.IO) {
            noteDao.deleteNote(note)
        }
    }

    override fun deleteAllNotes() = runBlocking {
        launch {
            noteDao.deleteAllNotes()
        }
    }
}
