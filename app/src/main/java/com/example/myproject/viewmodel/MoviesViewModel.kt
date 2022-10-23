package com.example.myproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myproject.data.DataMovie
import com.example.myproject.data.MovieListDataClass
import com.example.myproject.data.MovieDetails
import com.example.myproject.model.repository.MoviesDBRepository
import com.example.myproject.model.repository.MoviesDBRepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesViewModel {
    private val _movies = MutableLiveData<List<DataMovie?>>()
    val movies : LiveData<List<DataMovie?>> = _movies

    private val _moviesDetails = MutableLiveData<MovieDetails>()
    val moviesDetails : MutableLiveData<MovieDetails> = _moviesDetails

    private val mMoviesRepository: MoviesDBRepository = MoviesDBRepositoryImpl()

    fun getMovies() {
        val response = mMoviesRepository.getMovies()
        response.enqueue(object : Callback<MovieListDataClass> {
            override fun onResponse(
                call: Call<MovieListDataClass>,
                response: Response<MovieListDataClass>
            ) {
                _movies.postValue(response.body()?.results)
            }

            override fun onFailure(call: Call<MovieListDataClass>, t: Throwable) {

            }

        })


    }

    fun getMovieDetails(id:Int,apiKey:String){
        val response = mMoviesRepository.getMovieDetails(id,apiKey)
        response.enqueue(object : Callback<MovieDetails>{
            override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {
               _moviesDetails.postValue(response.body())
            }

            override fun onFailure(call: Call<MovieDetails>, t: Throwable) {

            }

        })
    }



}


