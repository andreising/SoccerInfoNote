package com.andreisingeleytsev.soccernotebet.data.room.repository

import com.andreisingeleytsev.soccernotebet.data.room.entities.NoteItem
import kotlinx.coroutines.flow.Flow

interface NoteItemRepository {
    
    suspend fun insertItem(item: NoteItem)
    suspend fun deleteItem(item: NoteItem)
    fun getItems(): Flow<List<NoteItem>>
    suspend fun getNoteByID(id: Int): NoteItem
}