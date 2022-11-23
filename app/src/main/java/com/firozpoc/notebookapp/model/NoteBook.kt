package com.firozpoc.notebookapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class NoteBook(
    val title: String,
    val desc: String?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}