package com.tjrushby.notelin.ui.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.tjrushby.notelin.R
import com.tjrushby.notelin.databinding.FragmentNotesBinding
import kotlinx.android.synthetic.main.fragment_notes.*
import kotlinx.android.synthetic.main.fragment_notes.view.*
import org.koin.android.viewmodel.ext.android.viewModel


class NotesFragment : Fragment() {

    private val viewModel: NotesViewModel by viewModel()
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var binding: FragmentNotesBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_notes, container, false)

        noteAdapter = NoteAdapter()

        binding.root.rvNotes.apply {
            adapter = noteAdapter
        }

        initViewModel()

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        buttonAddNote.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_addEditNotes)
        }
    }

    private fun initViewModel() {
        // set data for adapter
        viewModel.notesList.observe(this, Observer { newNotesList ->
            noteAdapter.updateData(newNotesList)
        })
    }
}
