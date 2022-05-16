package com.example.tytytest.data.repository

import androidx.lifecycle.LiveData
import com.example.tytytest.data.model.MovieItem
import com.example.tytytest.data.room.DaoMovie
import com.example.tytytest.domain.repository.MoviesRepositoryRoom

class MoviesRepositoryRoomImpl(private val dao: DaoMovie) : MoviesRepositoryRoom {
    //получение списка всех фильмов
    override val getAllMovies: LiveData<List<MovieItem>>
        get() = dao.getAllMovies()

    //функция для добавления фильмов в БД Room
    override suspend fun insertMovie(movie: MovieItem) {
        dao.insertMovie(movie)

    }


}