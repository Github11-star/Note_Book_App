package com.firozpoc.notebookapp.room

import androidx.room.*
import com.firozpoc.notebookapp.model.NoteBook

@Dao
interface NoteBookDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(noteBook: NoteBook)

    @Delete
    suspend fun delete(noteBook: NoteBook)

    @Query("SELECT * FROM NoteBook")
    suspend fun getAllNotebook():List<NoteBook>
}