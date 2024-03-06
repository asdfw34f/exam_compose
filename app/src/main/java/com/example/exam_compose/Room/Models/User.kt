package com.example.exam_compose.Room.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "user", indices = [Index("id")])
data class User (
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "username") val username:String,
    @ColumnInfo(name = "password") val password:String,
    @ColumnInfo(name = "firstname") val firstname :String,
    )