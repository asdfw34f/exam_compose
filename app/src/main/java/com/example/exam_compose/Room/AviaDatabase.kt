package com.example.exam_compose.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.exam_compose.Helpers.Converters
import com.example.exam_compose.Room.Dao.AviaDao
import com.example.exam_compose.Room.Dao.FavoriteDao
import com.example.exam_compose.Room.Dao.UserDao
import com.example.exam_compose.Room.Models.Avia
import com.example.exam_compose.Room.Models.Favorite
import com.example.exam_compose.Room.Models.User

@Database(entities = [Avia::class, User::class, Favorite::class], version = 1)
@TypeConverters( value = [Converters::class])
abstract class AviaDatabase: RoomDatabase(){
    abstract fun aviaDao():AviaDao
    abstract fun userDao():UserDao
    abstract fun favoriteDao():FavoriteDao

    companion object{
       fun getDb(context: Context):AviaDatabase{
           return Room.databaseBuilder(
               context.applicationContext,
               AviaDatabase::class.java,
               "avia_data.db"
           ).build()
       }
    }
}