package com.example.exam_compose.Room.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "favorite",
    indices = [Index("id")],
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["user_id"]
        )
    ]
)
data class Favorite(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name="user_id") val userId:Int,
    @ColumnInfo(name = "searchToken") val searchToken:String
)