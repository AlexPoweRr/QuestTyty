package com.example.tytytest.presentation.adapter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tytytest.MAIN
import com.example.tytytest.R
import com.example.tytytest.presentation.fragments.MainFragment
import com.example.tytytest.data.model.MovieItem
import com.example.tytytest.databinding.ItemBinding
import com.example.tytytest.presentation.view_model.MainViewModel
import java.util.ResourceBundle.getBundle

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>(), View.OnClickListener {


    var moviesList: List<MovieItem> = emptyList()

    class MainViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val BASE_URL = "https://image.tmdb.org/t/p/w500/"

        fun bind(movieItem: MovieItem) {
            binding.tvMovieTitle.text = movieItem.original_title
            binding.tvDate.text = movieItem.release_date
            Glide.with(itemView)
                .load(BASE_URL + movieItem.poster_path)
                .into(binding.imagePoster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(view, parent, false)
        binding.root.setOnClickListener(this)

        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(moviesList[position])
        val bindMovie = moviesList[position]
        holder.itemView.tag = bindMovie

    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    //при нажатии на View в onClick приходят данные о View, на которую мы кликнули и здесь же происходит
    //передача данных о выбранной View в DetailFragment
    override fun onClick(p0: View) {
        val movie = p0.tag as MovieItem
        //находится в MainViewModel(просто не знал куда его еще засунуть)
        getBundle(movie)
        Log.d("MyLog", "$movie")
    }

    //getMovie принимает данные из БД Room для отображения их в RecyclerView
    fun getMovie(movie: List<MovieItem>) {
        moviesList = movie
        notifyDataSetChanged()
    }

    //Инициализация Bundle для передачи данных о фильме из MainFragment в DetailFragment
    fun getBundle(movie: MovieItem) {
        val bundle = Bundle()
        bundle.putSerializable("movie", movie)
        MAIN.navController.navigate(R.id.action_mainFragment_to_detailsFragment, bundle)

    }
}