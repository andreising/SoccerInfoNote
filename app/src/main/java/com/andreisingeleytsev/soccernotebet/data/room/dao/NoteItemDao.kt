package com.andreisingeleytsev.soccernotebet.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.andreisingeleytsev.soccernotebet.data.room.entities.NoteItem
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: NoteItem)
    @Delete
    suspend fun deleteItem(item: NoteItem)
    @Query ("SELECT * FROM note_item")
    fun getItems(): Flow<List<NoteItem>>
    @Query ("SELECT * FROM note_item WHERE :id")
    suspend fun getNoteByID(id:Int): NoteItem
}