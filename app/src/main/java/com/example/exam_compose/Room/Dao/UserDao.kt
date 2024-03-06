package com.example.exam_compose.Room.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.exam_compose.Room.Models.User

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    fun getAll(): List<User>

    @Query("SELECT * FROM User Where username LIKE (:login) AND password LIKE (:password)")
    fun getCurrentUser(login:String, password:String):User;

    @Insert
    fun insertItem(user: User)

    @Delete
    fun delete(user: User)
}