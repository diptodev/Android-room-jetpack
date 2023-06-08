package com.excitedbroltd.androidroomjetpack.mvvm

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.excitedbroltd.androidroomjetpack.database.NoteDao
import com.excitedbroltd.androidroomjetpack.database.NoteDatabase
import com.excitedbroltd.androidroomjetpack.model.NoteModel
import kotlinx.coroutines.launch

class NoteViewModel(context: Context) : ViewModel() {
    private var userNote: NoteDatabase
    private lateinit var mnoteDao: NoteDao
    private var repository: Repository? = null
    private var allNotes: MutableState<List<NoteModel>> = mutableStateOf(listOf())

    init {
        userNote = NoteDatabase.getNoteDatabaseInstance(context)
        mnoteDao = userNote.noteDao()
        if (repository != null) repository else Repository(mnoteDao)
    }

    fun addNote(noteModel: NoteModel) {
        viewModelScope.launch {
            repository?.let {
                it.addNote(noteModel)
            }
        }
    }

    fun getNotes(): MutableState<List<NoteModel>> {
        viewModelScope.launch {
            repository?.let {
                allNotes.value = it.getAllNotes()
            }

        }
        return allNotes
    }


}