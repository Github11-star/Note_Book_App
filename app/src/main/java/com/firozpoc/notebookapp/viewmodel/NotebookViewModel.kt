package com.firozpoc.notebookapp.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.firozpoc.notebookapp.model.NoteBook
import com.firozpoc.notebookapp.repository.NotebookRepo
import kotlinx.coroutines.launch

class NotebookViewModel : ViewModel() {

    private val repo = NotebookRepo()
    val list = MutableLiveData<List<NoteBook>>()

    fun insert(context: Context, noteBook: NoteBook){
        viewModelScope.launch {
            repo.insert(context,noteBook)
        }
    }

    fun delete(context: Context, noteBook: NoteBook){
        viewModelScope.launch {
            repo.delete(context,noteBook)
        }
    }

    fun getAllNotebooks(context: Context){
        viewModelScope.launch {
          list.value= repo.getAllNotebook(context)
        }
    }
}