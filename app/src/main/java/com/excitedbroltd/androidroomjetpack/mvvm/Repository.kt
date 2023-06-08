package com.excitedbroltd.androidroomjetpack.mvvm

import com.excitedbroltd.androidroomjetpack.database.NoteDao
import com.excitedbroltd.androidroomjetpack.model.NoteModel

class Repository(private val noteDao: NoteDao) {
    suspend fun getAllNotes(): List<NoteModel> {
        return noteDao.getAllNotes()
    }

    suspend fun addNote(noteModel: NoteModel) {
        noteDao.addNote(noteModel)
    }
}