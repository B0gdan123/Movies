package com.example.myproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.example.myproject.model.apis.ApiInterface
import com.example.myproject.data.MovieDetails
import com.example.myproject.R
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesDetailsVideo : AppCompatActivity() {
    private lateinit var title:TextView
    private lateinit var releaseDate: TextView
    private lateinit var score: TextView
    private lateinit var overview: TextView
    private lateinit var banner: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_details_video)
        val id = intent.getIntExtra("id",0)
        Log.d("devLog","id $id")
        title = findViewById(R.id.movies_details_title)
        releaseDate= findViewById(R.id.movies_details_date)
        score = findViewById(R.id.movies_details_score)
        overview = findViewById(R.id.movies_details_body_overview)
        banner = findViewById(R.id.movies_details_image_banner)


        val apiInterface = id.let { ApiInterface.create().getMovieDetails(it,"e5f74869102e3b8ab1d63b79b819a3fe") }
        apiInterface.enqueue(object : Callback<MovieDetails>{
            override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {
                title.text = response.body()?.title
                releaseDate.text = response.body()?.releaseDate.toString()
                score.text = response.body()?.voteAverage.toString()
                overview.text= response.body()?.overview


                Picasso.get().load("https://image.tmdb.org/t/p/w500"+ response.body()?.backdropPath).into(banner)
            }

            override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
               Log.d("devLog","onFailure : ${t.message}")
            }

        })
    }
}