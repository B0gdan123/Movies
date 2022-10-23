package com.example.myproject.model.repository

import com.example.myproject.Const
import com.example.myproject.data.MovieListDataClass
import com.example.myproject.data.MovieDetails
import com.example.myproject.model.apis.ApiInterface
import retrofit2.Call

class MoviesDBRepositoryImpl : MoviesDBRepository {

    private val apiInterface = ApiInterface.create()
    override fun getMovies(): Call<MovieListDataClass> {
        return apiInterface.getMovie(Const.API_KEY,)
    }

    override fun getMovieDetails(id: Int, apiKey: String): Call<MovieDetails> {
        return apiInterface.getMovieDetails(id,apiKey)
    }

}