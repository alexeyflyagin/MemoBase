package com.aflyagin.memobase.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.aflyagin.memobase.data.database.entity.NoteEntity
import java.time.LocalDateTime

@Dao
interface NoteDao {

    @Insert
    fun insert(noteEntity: NoteEntity): Long

    @Update
    fun update(noteEntity: NoteEntity)

    @Query(value = "DELETE FROM Note WHERE id = :id")
    fun removeById(id: Long)

    @Query(value = "SELECT * FROM Note WHERE id = :id")
    fun getById(id: Long): NoteEntity?

    @Query(value = "SELECT * FROM Note")
    fun getAllNotes(): List<NoteEntity>

    @Query(value = "UPDATE Note SET is_favorite = :isFavorite WHERE id = :id")
    fun setIsFavorite(id: Long, isFavorite: Boolean)

    @Query(value = "UPDATE Note SET name = :name WHERE id = :id")
    fun setName(id: Long, name: String)

    @Query(value = "UPDATE Note SET catalog_id = :catalogId WHERE id = :id")
    fun move(id: Long, catalogId: Long)

    @Query(value = "UPDATE Note SET content = :content WHERE id = :id")
    fun setContent(id: Long, content: String)

}