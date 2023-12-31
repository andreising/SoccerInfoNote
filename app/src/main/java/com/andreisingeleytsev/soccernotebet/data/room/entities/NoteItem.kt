package com.andreisingeleytsev.soccernotebet.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "note_item")
data class NoteItem(
    @PrimaryKey
    val id: Int? = null,
    val name: String,
    val title: String
)
