package com.tjrushby.notelin.ui.notes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tjrushby.notelin.R
import com.tjrushby.notelin.data.Note
import com.tjrushby.notelin.databinding.ItemNoteBinding
import kotlin.properties.Delegates


class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private var notesList: List<Note> by Delegates.observable(emptyList()) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding: ItemNoteBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_note, parent, false)

        return NoteViewHolder(binding)
    }

    override fun getItemCount(): Int = notesList.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        if (position != RecyclerView.NO_POSITION) {
            val note: Note = notesList[position]
            holder.bind(note)
        }
    }

    fun updateData(newNotesList: List<Note>) {
        notesList = newNotesList
    }

    class NoteViewHolder(binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            // todo onClickListener here, fun bind() can also take a listener as an argument
        }
    }

}
