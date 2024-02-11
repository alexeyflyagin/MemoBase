package com.aflyagin.memobase.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aflyagin.memobase.data.database.converter.LocalDateTimeConverter
import com.aflyagin.memobase.data.database.dao.CatalogDao
import com.aflyagin.memobase.data.database.dao.NoteDao
import com.aflyagin.memobase.data.database.entity.CatalogEntity
import com.aflyagin.memobase.data.database.entity.NoteEntity

@Database(entities = [NoteEntity::class, CatalogEntity::class], version = 1)
@TypeConverters(LocalDateTimeConverter::class)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
    abstract fun catalogDao(): CatalogDao
}