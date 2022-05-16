package com.example.tytytest.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tytytest.data.model.MovieItem
import com.example.tytytest.databinding.FragmentDatailsBinding

class DetailsFragment : Fragment() {

    lateinit var binding: FragmentDatailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDatailsBinding.inflate(layoutInflater, container, false)
        init()
        return binding.root
    }

    private fun init() {

        //Получение данных о фильме из MainFragment
        val movie = arguments?.getSerializable("movie") as? MovieItem

        //Вставляем данные во View
        binding.tvMovieTitleDetails.text = movie?.original_title
        binding.tvDateDetails.text = movie?.release_date
        binding.tvDescription.text = movie?.overview
    }


}