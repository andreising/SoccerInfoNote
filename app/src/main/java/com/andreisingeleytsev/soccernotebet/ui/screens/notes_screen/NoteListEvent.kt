package com.andreisingeleytsev.soccernotebet.ui.screens.notes_screen

import com.andreisingeleytsev.soccernotebet.data.room.entities.NoteItem


sealed class NoteListEvent{
    data class OnDeleteNote(val item: NoteItem): NoteListEvent()
    data class OnEditNote(val item: NoteItem): NoteListEvent()
    object CreateNote: NoteListEvent()
    data class OnCreateNote(val title: String, val text: String): NoteListEvent()
}
