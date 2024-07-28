package com.ys.notesapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class RoomDBHelper : RoomDatabase() {

    abstract val dao: NoteDao

    // create like-singleton pattern design for the RoomDB which
    // has a public not private constructor
    companion object {
        @Volatile
        private var INSTANCE: RoomDBHelper? = null

        fun getInstance(c: Context): RoomDBHelper {
            return INSTANCE ?: synchronized(this) {
                val instance = Room
                    .databaseBuilder(c, RoomDBHelper::class.java, "MyDB")
                    .build()
                INSTANCE = instance
                //return value
                instance
            }
        }
    }

}