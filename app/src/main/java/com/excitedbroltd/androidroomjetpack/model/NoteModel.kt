package com.excitedbroltd.androidroomjetpack.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userNote")
class NoteModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val date: Long,
    val title: String,
    val desc: String
)