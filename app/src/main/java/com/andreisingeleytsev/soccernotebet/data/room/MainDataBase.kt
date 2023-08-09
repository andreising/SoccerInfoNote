package com.andreisingeleytsev.soccernotebet.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.andreisingeleytsev.soccernotebet.data.room.dao.NoteItemDao

import com.andreisingeleytsev.soccernotebet.data.room.entities.NoteItem

@Database(
    entities = [NoteItem::class],
    version = 1
)
abstract class MainDataBase: RoomDatabase() {
    abstract val noteItemDao: NoteItemDao
}