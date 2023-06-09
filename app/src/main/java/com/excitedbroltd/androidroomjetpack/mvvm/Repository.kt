package com.excitedbroltd.androidroomjetpack.mvvm

import androidx.compose.runtime.MutableState
import androidx.lifecycle.LiveData
import com.excitedbroltd.androidroomjetpack.database.NoteDao
import com.excitedbroltd.androidroomjetpack.model.NoteModel

class Repository(private val noteDao: NoteDao) {
       fun getAllNotes(): LiveData<List<NoteModel>> {
        return noteDao.getAllNotes()
    }

    suspend fun addNote(noteModel: NoteModel) {
        noteDao.addNote(noteModel)
    }
}