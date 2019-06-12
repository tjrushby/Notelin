package com.tjrushby.notelin.ui.notes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tjrushby.notelin.R
import com.tjrushby.notelin.data.Note
import com.tjrushby.notelin.databinding.ItemNoteBinding


class NoteAdapter(private var noteClickCallback: NoteClickCallback) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private var notesList: List<Note> = emptyList()

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
        notifyDataSetChanged()
    }

    inner class NoteViewHolder(private var binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    noteClickCallback.onClick(adapterPosition)
                }
            }
        }

        fun bind(note: Note) {
            binding.note = note
        }
    }

    interface NoteClickCallback {
        fun onClick(listPosition: Int)
    }
}
