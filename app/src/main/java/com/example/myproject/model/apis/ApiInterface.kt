package com.example.myproject.model.apis

import com.example.myproject.data.MovieDetails
import com.example.myproject.TestMovie
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiInterface {

    @GET("3/movie/popular")
    fun getMovie(@Query ("api_key")sort : String): Call<TestMovie>

    @GET("3/movie/{movie_id}")
    fun getMovieDetails(@Path ("movie_id")movieId: Int, @Query ("api_key")sort:String): Call<MovieDetails>

    companion object{
         var BASE_URL = "https://api.themoviedb.org/"
        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}






