package com.tjrushby.notelin.di

import androidx.room.Room
import com.tjrushby.notelin.data.NoteDatabase
import com.tjrushby.notelin.data.NoteRepository
import com.tjrushby.notelin.data.NoteRepositoryImpl
import com.tjrushby.notelin.ui.notes.NotesViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModules = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            NoteDatabase::class.java,
            "notes.db"
        ).build()
    }

    factory { get<NoteDatabase>().noteDao() }
    factory<NoteRepository> { NoteRepositoryImpl(noteDao = get()) }

    viewModel { NotesViewModel(repo = get()) }
}
