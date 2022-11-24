package com.firozpoc.notebookapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.firozpoc.notebookapp.R
import com.firozpoc.notebookapp.model.NoteBook
import com.firozpoc.notebookapp.viewmodel.NotebookViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AddFragment : Fragment() {

    lateinit var navController: NavController
    lateinit var viewModel: NotebookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel=ViewModelProvider(this)[NotebookViewModel::class.java]
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController=Navigation.findNavController(view)

        val title=view.findViewById<EditText>(R.id.addTitle)
        val desc=view.findViewById<EditText>(R.id.addDecs)

        val button= view.findViewById<FloatingActionButton>(R.id.check_notebook)
        button.setOnClickListener {
            if (title.text.trim().toString().isEmpty()) return@setOnClickListener
            val noteBook=NoteBook(title.text.trim().toString(),desc.text.trim().toString())
            saveInDb(noteBook)
            navController.navigate(R.id.action_addFragment_to_mainFragment)
        }
    }

    private fun saveInDb(noteBook: NoteBook) {
        context?.let { viewModel.insert(it,noteBook) }
    }

}