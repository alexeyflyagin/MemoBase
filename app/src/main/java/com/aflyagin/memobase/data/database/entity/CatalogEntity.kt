package com.aflyagin.memobase.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "Folder")
data class CatalogEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "last_update_date") val lastUpdateDate: LocalDateTime = LocalDateTime.now(),
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "color") val color: Int,
)