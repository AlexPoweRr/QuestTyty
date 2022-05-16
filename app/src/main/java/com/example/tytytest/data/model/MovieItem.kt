package com.example.tytytest.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "movie_table")
data class MovieItem(
    val adult: Boolean,
    val backdrop_path: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val vote_average: Double

): Serializable