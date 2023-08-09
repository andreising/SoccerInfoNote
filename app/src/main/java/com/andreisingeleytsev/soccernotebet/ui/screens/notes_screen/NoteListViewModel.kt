package com.andreisingeleytsev.soccernotebet.ui.screens.notes_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreisingeleytsev.soccernotebet.data.room.entities.NoteItem
import com.andreisingeleytsev.soccernotebet.data.room.repository.NoteItemRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(
    private val noteItemRepository: NoteItemRepository
): ViewModel() {
    val noteList = noteItemRepository.getItems()
    private var id: Int? = null

    val isListNote = mutableStateOf(true)
    private var noteID = -1

    var name by mutableStateOf("")


    var title by mutableStateOf("")


    fun onEvent(event: NoteListEvent){
        when(event) {
            is NoteListEvent.CreateNote -> {
                isListNote.value = false
                name = ""
                title = ""
                id = null
            }
            is NoteListEvent.OnCreateNote -> {
                isListNote.value = true
                viewModelScope.launch{
                    noteItemRepository.insertItem(NoteItem(id, name, title))
                }
            }
            is NoteListEvent.OnDeleteNote -> {
                viewModelScope.launch{
                    noteItemRepository.deleteItem(event.item)
                }
            }
            is NoteListEvent.OnEditNote -> {
                isListNote.value = false
                id = event.item.id
                name = event.item.name
                title = event.item.title
            }
        }
    }

}