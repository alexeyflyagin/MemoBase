package com.aflyagin.memobase.data

import com.aflyagin.memobase.data.database.entity.CatalogEntity
import com.aflyagin.memobase.data.database.entity.NoteEntity
import com.aflyagin.memobase.domain.repository.NoteRepository

class NoteRepositoryImpl(private val noteService: NoteService) : NoteRepository {

    override suspend fun insertNote(noteEntity: NoteEntity): Long {
        return noteService.insertNote(noteEntity)
    }

    override suspend fun updateNote(noteEntity: NoteEntity) {
        return noteService.updateNote(noteEntity)
    }

    override suspend fun updateCatalog(catalogEntity: CatalogEntity) {
        return noteService.updateCatalog(catalogEntity)
    }

    override suspend fun removeNoteById(id: Long) {
        return noteService.removeNoteById(id)
    }

    override suspend fun getNoteById(id: Long): NoteEntity? {
        return noteService.getNoteById(id)
    }

    override suspend fun getAllNotes(): List<NoteEntity> {
        return noteService.getAllNotes()
    }

    override suspend fun insertCatalog(catalogEntity: CatalogEntity): Long {
        return noteService.insertCatalog(catalogEntity)
    }

    override suspend fun removeCatalogById(id: Long) {
        return noteService.removeCatalogById(id)
    }

    override suspend fun getCatalogById(id: Long): CatalogEntity? {
        return noteService.getCatalogById(id)
    }

    override suspend fun getAllCatalogs(): List<CatalogEntity> {
        return noteService.getAllCatalogs()
    }

    override suspend fun getAllNotesFromCatalog(id: Long): List<NoteEntity> {
        return noteService.getAllNotesFromCatalog(id)
    }
}