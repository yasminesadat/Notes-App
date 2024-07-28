package com.ys.notesapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ys.notesapp.database.Note
import com.ys.notesapp.database.RoomDBHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// use AndroidViewModel, not ViewModel
// never pass context to viewModel as it can outlive the current context
class NoteViewModel(app: Application): AndroidViewModel(app) {
    val db = RoomDBHelper.getInstance(app)

    fun upsertNote(n: Note){
        viewModelScope.launch(Dispatchers.IO){
            db.dao.upsertNote(n)
        }
    }

    fun deleteNote(n: Note){
        viewModelScope.launch(Dispatchers.IO)
        {
            db.dao.deleteNote(n)
        }
    }

    fun getNotes()= db.dao.getAllNotes()

}