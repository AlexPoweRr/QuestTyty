package com.example.tytytest.data.model

import com.google.gson.annotations.SerializedName

data class PopMovies(
    val page: Int,
    @SerializedName("results")
    val movieItems: List<MovieItem>,
    val total_pages: Int,
    val total_results: Int
)