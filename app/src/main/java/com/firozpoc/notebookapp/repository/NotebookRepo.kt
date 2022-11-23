package com.firozpoc.notebookapp.repository

import android.content.Context
import com.firozpoc.notebookapp.model.NoteBook
import com.firozpoc.notebookapp.room.NoteBookDatabase

class NotebookRepo {

    suspend fun insert(context: Context, noteBook: NoteBook){
        NoteBookDatabase.get(context).getNotebookDao().insert(noteBook)
    }

    suspend fun delete(context: Context, noteBook: NoteBook){
        NoteBookDatabase.get(context).getNotebookDao().delete(noteBook)
    }

    suspend fun getAllNotebook(context: Context) : List<NoteBook>{
        return NoteBookDatabase.get(context).getNotebookDao().getAllNotebook()
    }
}