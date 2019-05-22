package com.tjrushby.notelin.ui.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.tjrushby.notelin.R
import kotlinx.android.synthetic.main.fragment_notes.*


class NotesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_notes, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        buttonAddNote.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_addEditNotes)
        }
    }
}
