package com.andreisingeleytsev.soccernotebet.data.room.repository.implementations

import com.andreisingeleytsev.soccernotebet.data.room.dao.NoteItemDao
import com.andreisingeleytsev.soccernotebet.data.room.entities.NoteItem
import com.andreisingeleytsev.soccernotebet.data.room.repository.NoteItemRepository
import kotlinx.coroutines.flow.Flow

class NoteItemRepositoryImpl(
    private val dao: NoteItemDao
) : NoteItemRepository {

    override suspend fun insertItem(item: NoteItem) {
        dao.insertItem(item)
    }

    override suspend fun deleteItem(item: NoteItem) {
        dao.deleteItem(item)
    }

    override fun getItems(): Flow<List<NoteItem>> {
        return dao.getItems()
    }

    override suspend fun getNoteByID(id: Int): NoteItem {
        return dao.getNoteByID(id)
    }
}