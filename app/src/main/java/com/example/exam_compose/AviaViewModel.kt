package com.example.exam_compose

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.example.exam_compose.Room.AviaDatabase
import com.example.exam_compose.Room.Models.Favorite
import com.example.exam_compose.Room.Models.User

class AviaViewModel(private val savedStateHandle: SavedStateHandle, val applicationContext: Context): ViewModel() {

    val db = Room.databaseBuilder(
        applicationContext,
        AviaDatabase::class.java,
        "avia-db")
        .build()

    private val userDao = db.userDao()
    private val favoriteDao = db.favoriteDao()

    lateinit var currentUser:User
    lateinit var currentFavorite: List<Favorite>

    fun logIn(username: String, password: String): User {
        currentUser = userDao.getCurrentUser(username, password)
        currentFavorite = favoriteDao.getAll(currentUser.id)
        return currentUser
    }

}
