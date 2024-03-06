package com.example.exam_compose.Room.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.exam_compose.Room.Models.Favorite

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM favorite WHERE user_id LIKE (:userId)")
    fun getAll(userId:Int): List<Favorite>

    @Insert
    fun insertAllItems(favoriteList:List<Favorite>)

    @Delete
    fun delete(favorite: Favorite)
}