package com.aflyagin.memobase.data.database.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.aflyagin.memobase.data.database.converter.LocalDateTimeConverter
import java.time.LocalDateTime

@Entity(
    tableName = "Note",
    foreignKeys = [ForeignKey(
        entity = CatalogEntity::class,
        parentColumns = ["id"],
        childColumns = ["catalog_id"],
        onDelete = ForeignKey.CASCADE,
    )]
)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "is_favorite") val isFavorite: Boolean = false,
    @ColumnInfo(name = "catalog_id", index = true) val catalogId: Long,
    @ColumnInfo(name = "last_update_date") val lastUpdateDate: LocalDateTime = LocalDateTime.now(),
    @ColumnInfo(name = "sign") val sign: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "content") val content: String,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        id = parcel.readLong(),
        isFavorite = parcel.readByte() != 0.toByte(),
        catalogId = parcel.readLong(),
        lastUpdateDate = LocalDateTimeConverter().fromLong(parcel.readLong())!!,
        sign = parcel.readString()!!,
        name = parcel.readString()!!,
        content = parcel.readString()!!,
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeByte(if (isFavorite) 1 else 0)
        parcel.writeLong(catalogId)
        parcel.writeLong(LocalDateTimeConverter().toLong(lastUpdateDate)!!)
        parcel.writeString(sign)
        parcel.writeString(name)
        parcel.writeString(content)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NoteEntity> {
        override fun createFromParcel(parcel: Parcel): NoteEntity {
            return NoteEntity(parcel)
        }

        override fun newArray(size: Int): Array<NoteEntity?> {
            return arrayOfNulls(size)
        }
    }
}