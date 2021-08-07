package com.example.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) :AndroidViewModel(application) {
    private val respository: Notesrespository
    val allNotes:LiveData<List<Notes>>

init {
    val dao=NoteDataBase.getDatabase(application).getNoteDao()
         respository=Notesrespository(dao)
        allNotes=respository.allNotes
}
    fun deleteNote(note:Notes)= viewModelScope.launch(Dispatchers.IO){
respository.delete(note)
    }
    fun insertNote(note:Notes)= viewModelScope.launch(Dispatchers.IO){
        respository.insert(note)
    }
}