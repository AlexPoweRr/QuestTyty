package com.example.tytytest.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tytytest.data.model.MovieItem

@Database(entities = [MovieItem::class], version = 1, exportSchema = false)
abstract class MoviesRoomDatabase : RoomDatabase() {

    abstract fun getDao(): DaoMovie


    companion object {
        var INSTANCE: MoviesRoomDatabase? = null

        //создание singleton
        @Synchronized
        fun getInstance(context: Context): MoviesRoomDatabase {

            return if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, MoviesRoomDatabase::class.java, "db")
                    .build()
                INSTANCE as MoviesRoomDatabase
            } else INSTANCE as MoviesRoomDatabase

        }
    }
}
