package com.firozpoc.notebookapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.firozpoc.notebookapp.model.NoteBook

@Dao
interface NoteBookDAO {

    @Insert
    suspend fun insert(noteBook: NoteBook)

    @Delete
    suspend fun delete(noteBook: NoteBook)

    @Query("SELECT * FROM NoteBook")
    suspend fun getAllNotebook(): List<NoteBook>
}