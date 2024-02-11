package com.aflyagin.memobase.data.database

import com.aflyagin.memobase.data.NoteService
import com.aflyagin.memobase.data.database.entity.CatalogEntity
import com.aflyagin.memobase.data.database.entity.NoteEntity
import java.time.LocalDateTime

class NoteServiceImpl(private val database: NoteDatabase) : NoteService {

    override suspend fun insertNote(noteEntity: NoteEntity): Long {
        return database.noteDao().insert(noteEntity)
    }

    override suspend fun updateNote(noteEntity: NoteEntity) {
        val entity = noteEntity.copy(lastUpdateDate = LocalDateTime.now())
        return database.noteDao().update(entity)
    }

    override suspend fun updateCatalog(catalogEntity: CatalogEntity) {
        val entity = catalogEntity.copy(lastUpdateDate = LocalDateTime.now())
        return database.catalogDao().update(entity)
    }

    override suspend fun removeNoteById(id: Long) {
        return database.noteDao().removeById(id)
    }

    override suspend fun getNoteById(id: Long): NoteEntity? {
        return database.noteDao().getById(id)
    }

    override suspend fun getAllNotes(): List<NoteEntity> {
        return database.noteDao().getAllNotes()
    }

    override suspend fun insertCatalog(catalogEntity: CatalogEntity): Long {
        return database.catalogDao().insert(catalogEntity)
    }

    override suspend fun removeCatalogById(id: Long) {
        return database.catalogDao().removeById(id)
    }

    override suspend fun getCatalogById(id: Long): CatalogEntity? {
        return database.catalogDao().getById(id)
    }

    override suspend fun getAllCatalogs(): List<CatalogEntity> {
        return database.catalogDao().getAllCatalogs()
    }

    override suspend fun getAllNotesFromCatalog(catalogId: Long): List<NoteEntity> {
        return database.catalogDao().getAllNotes(catalogId)
    }

}