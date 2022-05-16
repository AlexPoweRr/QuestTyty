package com.example.tytytest.data.network

import androidx.lifecycle.LiveData
import com.example.tytytest.data.model.PopMovies
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface MainScreenApi {

    //Запрос на получение списка фильмов
    @GET("movie/popular?api_key=e93bb84f52ac4003b04b757c5dbe87ec&language=en-US&page=1")
    suspend fun getMovies(): Response<PopMovies>


    companion object {
        operator fun invoke(): MainScreenApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.themoviedb.org/3/")
                .build()
                .create(MainScreenApi::class.java)
        }
    }
}