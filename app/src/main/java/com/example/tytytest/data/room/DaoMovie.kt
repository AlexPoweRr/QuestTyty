package com.example.tytytest.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tytytest.data.model.MovieItem

@Dao
interface DaoMovie {

    //запрос на получение всего списка фильмов из Room
    @Query("SELECT * FROM movie_table")
    fun getAllMovies(): LiveData<List<MovieItem>>

    //функция для добавления данных в БД Room
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: MovieItem)
}