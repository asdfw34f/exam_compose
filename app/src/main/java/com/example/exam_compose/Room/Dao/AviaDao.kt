package com.example.exam_compose.Room.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.exam_compose.Room.Models.Avia

@Dao
interface AviaDao {
    @Query("SELECT * FROM Avia")
    fun getAll():List<Avia>

    @Query("SELECT * FROM Avia WHERE searchToken IN (:searchTokens)")
    fun getAllByIds(searchTokens:Array<String>):List<Avia>

    @Query("SELECT * FROM Avia WHERE startCity LIKE :startCityName AND endCity LIKE :endCityName")
    fun findByStartCity(startCityName:String, endCityName:String):List<Avia>

    @Insert
    fun insertItem(avia:Avia)

    @Delete
    fun delete(avia: Avia)
}