package com.tjrushby.notelin.ui.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tjrushby.notelin.data.Note
import com.tjrushby.notelin.data.NoteRepository


class NotesViewModel(private val repo: NoteRepository) : ViewModel() {
    val notesList: LiveData<List<Note>> = repo.getAllNotes()
}
