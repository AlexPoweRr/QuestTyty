package com.example.tytytest.domain.repository

import androidx.lifecycle.LiveData
import com.example.tytytest.data.model.MovieItem

interface MoviesRepositoryRoom {

    //Функция репозитория для добавления данных в БД Room
    suspend fun insertMovie(movie: MovieItem)

    //Переменная, хранящая в себе всех фильмы из БД Room
    val getAllMovies: LiveData<List<MovieItem>>
}