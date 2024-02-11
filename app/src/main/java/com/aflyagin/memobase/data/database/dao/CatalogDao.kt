package com.aflyagin.memobase.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.aflyagin.memobase.data.database.entity.CatalogEntity
import com.aflyagin.memobase.data.database.entity.NoteEntity
import java.time.LocalDateTime

@Dao
interface CatalogDao {

    @Insert
    fun insert(catalogEntity: CatalogEntity): Long

    @Update
    fun update(catalogEntity: CatalogEntity)

    @Query(value = "DELETE FROM Folder WHERE id = :id")
    fun removeById(id: Long)

    @Query(value = "SELECT * FROM Folder WHERE id = :id")
    fun getById(id: Long): CatalogEntity?

    @Query(value = "SELECT * FROM Folder")
    fun getAllCatalogs(): List<CatalogEntity>

    @Query(value = "SELECT * FROM Note WHERE catalog_id = :catalogId")
    fun getAllNotes(catalogId: Long): List<NoteEntity>
}