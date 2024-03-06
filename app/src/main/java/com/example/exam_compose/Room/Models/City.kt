package com.example.exam_compose.Room.Models


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "avia")
data class Avia(
    @PrimaryKey val searchToken:String,
    val startCity:String,
    val startCityCode:String,
    val endCity:String,
    val endCityCode:String,
    @ColumnInfo(name = "startDate") val startDate: Date?,
    @ColumnInfo(name = "endDate") val endDate: Date?,
    val price:Int
    )