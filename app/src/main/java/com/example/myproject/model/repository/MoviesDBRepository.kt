package com.example.myproject.model.repository

import com.example.myproject.data.MovieListDataClass
import com.example.myproject.data.MovieDetails
import retrofit2.Call

interface MoviesDBRepository  {
    fun getMovies(): Call<MovieListDataClass>

    fun getMovieDetails(id:Int,apiKey: String):Call<MovieDetails>

}