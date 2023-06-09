package com.excitedbroltd.androidroomjetpack.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.excitedbroltd.androidroomjetpack.model.NoteModel

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(noteModel: NoteModel)

    @Query("SELECT * FROM userNote ORDER BY id ASC")
    fun getAllNotes(): LiveData<List<NoteModel>>

    @Delete
    fun deleteNote(noteModel: NoteModel)

    @Update
    suspend fun updateNote(noteModel: NoteModel)
}