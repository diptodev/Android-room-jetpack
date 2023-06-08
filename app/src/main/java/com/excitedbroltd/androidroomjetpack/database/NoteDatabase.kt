package com.excitedbroltd.androidroomjetpack.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.excitedbroltd.androidroomjetpack.model.NoteModel


@Database(entities = [NoteModel::class], version = 1, exportSchema = false)
abstract class NoteDatabase() : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        var INSTANCE: NoteDatabase? = null

        fun getNoteDatabaseInstance(context: Context): NoteDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) INSTANCE
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    name = "userNote"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}