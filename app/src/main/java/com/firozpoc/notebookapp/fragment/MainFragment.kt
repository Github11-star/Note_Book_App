package com.firozpoc.notebookapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.firozpoc.notebookapp.R
import com.firozpoc.notebookapp.adapters.MyAdapter
import com.firozpoc.notebookapp.viewmodel.NotebookViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainFragment : Fragment() {

    lateinit var navController: NavController
    lateinit var viewModel: NotebookViewModel
    var adapter=MyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel=ViewModelProvider(this)[NotebookViewModel::class.java]
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController=Navigation.findNavController(view)

        val button=view.findViewById<FloatingActionButton>(R.id.addNotebook)
        button.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_addFragment)
        }

        val recycler=view.findViewById<RecyclerView>(R.id.recycler)
        context?.let { viewModel.getAllNotebooks(it) }
        viewModel.list.observe(viewLifecycleOwner) {
            adapter.setContentList(it)
            recycler.also {
                recycler.adapter = adapter
            }
        }

    }



}