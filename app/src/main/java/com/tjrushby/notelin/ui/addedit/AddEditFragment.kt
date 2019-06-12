package com.tjrushby.notelin.ui.addedit

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.tjrushby.notelin.R
import com.tjrushby.notelin.databinding.FragmentAddEditBinding
import com.tjrushby.notelin.ui.NotesViewModel
import kotlinx.android.synthetic.main.fragment_add_edit.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class AddEditFragment : Fragment() {

    private lateinit var binding: FragmentAddEditBinding
    private val viewModel by sharedViewModel<NotesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_edit, container, false)

        initViewModel()

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_add_edit, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_save -> {
                viewModel.saveNote(binding.note, etTitle.text.toString(), etDescription.text.toString())
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun initViewModel() {
        viewModel.selectedNote.observe(this, Observer { selectedNote ->
            binding.note = selectedNote
        })

        viewModel.saved.observe(this, Observer { saved  ->
            when (saved) {
                true -> findNavController().popBackStack()
            }
        })
    }
}
