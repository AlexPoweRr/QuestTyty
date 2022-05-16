package com.example.tytytest.presentation.view_model

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.tytytest.MAIN
import com.example.tytytest.R
import com.example.tytytest.ROOM
import com.example.tytytest.data.model.MovieItem
import com.example.tytytest.data.model.PopMovies
import com.example.tytytest.data.network.MainScreenApi
import com.example.tytytest.data.network.Network
import com.example.tytytest.data.repository.MoviesRepositoryImpl
import com.example.tytytest.data.repository.MoviesRepositoryRoomImpl
import com.example.tytytest.data.room.MoviesRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repoRetrofit = MoviesRepositoryImpl(MainScreenApi())
    private val context = application

    fun initDatabase() {
        val dao = MoviesRoomDatabase.getInstance(context).getDao()
        ROOM = MoviesRepositoryRoomImpl(dao)
    }

//Проверка подключения к интернету
    init {
        viewModelScope.launch(Dispatchers.IO) {
            if (Network.checkConnectivity(context)){
                movieListSelector(repoRetrofit.getMovies().movieItems)
            } else{
                Log.d("MyLog","Network exception")
            }
        }
    }

//Превращаем список в отдельные элементы для добавления в БД Room
    private suspend fun movieListSelector(list: List<MovieItem>) {
        for (movie in list) {
            ROOM.insertMovie(movie)
        }
    }

//Получение списка всех фильмов из БД Room
    fun getAllRoomMovies(): LiveData<List<MovieItem>> {
        return ROOM.getAllMovies
    }

}