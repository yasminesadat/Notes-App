package com.ys.notesapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("note")
class Note (
    @ColumnInfo("_id")
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,

    @ColumnInfo("note_title")
    val noteTitle: String,

    @ColumnInfo("note_details")
    val noteDetails: String
)