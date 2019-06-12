package com.tjrushby.notelin.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import timber.log.Timber


interface NoteRepository {
    fun getAllNotes(): LiveData<List<Note>>

    fun saveNote(note: Note): Job

    fun updateNote(note: Note): Job

    fun deleteNote(note: Note): Job

    fun deleteAllNotes(): Job
}

class NoteRepositoryImpl(private val noteDao : NoteDao) : NoteRepository{

    override fun getAllNotes(): LiveData<List<Note>> {
        return liveData { emitSource(noteDao.getAllNotes()) }
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
