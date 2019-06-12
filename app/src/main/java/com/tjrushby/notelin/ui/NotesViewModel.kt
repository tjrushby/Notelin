package com.tjrushby.notelin.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tjrushby.notelin.SingleLiveEvent
import com.tjrushby.notelin.data.Note
import com.tjrushby.notelin.data.NoteRepository


class NotesViewModel(private val repo: NoteRepository) : ViewModel() {
    var notesList: LiveData<List<Note>> = repo.getAllNotes()
    var selectedNote: SingleLiveEvent<Note> = SingleLiveEvent()
    var saved: SingleLiveEvent<Boolean> = SingleLiveEvent()

    fun saveNote(note: Note?, title: String, description: String) {
        if (note == null) {
            // creating a new note
            repo.saveNote(Note(title, description))
        } else {
            // updating an existing note
            note.title = title
            note.description = description
            repo.updateNote(note)
        }

        saved.value = true
    }

    fun selectedNote(listPosition: Int) {
        selectedNote.value = notesList.value!![listPosition]
    }
}
