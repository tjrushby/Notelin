package com.tjrushby.notelin.ui.addeditnote

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.tjrushby.notelin.R
import timber.log.Timber

class AddEditNoteFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_add_edit_note, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_add_edit, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_save -> {
                Timber.d("save")
                return false
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
