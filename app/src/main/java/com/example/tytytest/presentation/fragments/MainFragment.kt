package com.example.tytytest.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.tytytest.MAIN
import com.example.tytytest.R
import com.example.tytytest.data.model.MovieItem
import com.example.tytytest.databinding.FragmentMainBinding
import com.example.tytytest.presentation.adapter.MainAdapter
import com.example.tytytest.presentation.view_model.MainViewModel


class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding
    lateinit var adapter: MainAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Инициализация RecView
        recyclerView = binding.recView
        adapter = MainAdapter()
        recyclerView.adapter = adapter

        //Инициализация ViewModel
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.initDatabase()

        //Передача всех фильмов из Room в RecView
        viewModel.getAllRoomMovies().observe(viewLifecycleOwner) {
            adapter.getMovie(it)
        }

    }



}
