package com.ys.notesapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    /*
    //insert into note (note_details) values ()
    @Insert
    fun saveNote(n: Note)

    // update note set note_details = hello world where _id ==5
    @Update
    fun updateNote(n: Note)
     */
    //                  |
    //                  v
    //knows update if id is passed
    @Upsert
    suspend fun upsertNote(n: Note)

    @Delete
    suspend fun deleteNote(n: Note)

    @Query("SELECT * FROM note")
    fun getAllNotes(): Flow<List<Note>>
}