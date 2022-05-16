package com.example.tytytest.data.repository

import com.example.tytytest.data.network.MainScreenApi


class MoviesRepositoryImpl(private val api: MainScreenApi) : SafeApiRequest() {

    // получаем фильмы из Api
    suspend fun getMovies() = apiRequest { api.getMovies() }
}

