package com.aflyagin.memobase.domain.repository

import com.aflyagin.memobase.data.database.entity.CatalogEntity
import com.aflyagin.memobase.data.database.entity.NoteEntity

interface NoteRepository {

    //region NOTE
    suspend fun insertNote(noteEntity: NoteEntity): Long

    suspend fun updateNote(noteEntity: NoteEntity)

    suspend fun removeNoteById(id: Long)

    suspend fun getNoteById(id: Long): NoteEntity?

    suspend fun getAllNotes(): List<NoteEntity>
    //endregion

    //region CATALOG
    suspend fun insertCatalog(catalogEntity: CatalogEntity): Long

    suspend fun updateCatalog(catalogEntity: CatalogEntity)

    suspend fun removeCatalogById(id: Long)

    suspend fun getCatalogById(id: Long): CatalogEntity?

    suspend fun getAllCatalogs(): List<CatalogEntity>

    suspend fun getAllNotesFromCatalog(id: Long): List<NoteEntity>
    //endregion
}