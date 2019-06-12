package com.tjrushby.notelin.ui.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tjrushby.notelin.SingleLiveEvent
import com.tjrushby.notelin.data.Note
import com.tjrushby.notelin.data.NoteRepository


class NotesViewModel(private val repo: NoteRepository) : ViewModel() {
    var notesList: LiveData<List<Note>> = repo.getAllNotes()
    var saved: SingleLiveEvent<Boolean> = SingleLiveEvent()

    fun saveNote(title: String, description: String) {
        repo.saveNote(Note(title, description))
        saved.value = true
    }
}
