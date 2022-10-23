package com.example.myproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.myproject.Const
import com.example.myproject.data.MovieDetails
import com.example.myproject.R
import com.example.myproject.viewmodel.MoviesViewModel
import com.squareup.picasso.Picasso


class MoviesDetailsVideoActivity : AppCompatActivity() {

    private val mViewModel: MoviesViewModel = MoviesViewModel()

    private lateinit var mTitle: TextView
    private lateinit var mReleaseDate: TextView
    private lateinit var mScore: TextView
    private lateinit var mOverview: TextView
    private lateinit var mBanner: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_details_video)

        val id = intent.getIntExtra("id", 0)
        initViews()
        initObServers()
        mViewModel.getMovieDetails(id, Const.API_KEY)
    }

    private fun initObServers() {
        mViewModel.apply {
            moviesDetails.observe(this@MoviesDetailsVideoActivity) {
                setMovieInformation(it)
            }
        }
    }

    private fun setMovieInformation(movieDetails: MovieDetails) {
        mTitle.text = movieDetails.title
        mReleaseDate.text = movieDetails.release_date
        mScore.text = movieDetails.vote_average.toString()
        mOverview.text = movieDetails.overview

        Picasso.get().load("https://image.tmdb.org/t/p/w500" + movieDetails.backdrop_path)
            .into(mBanner)
    }

    private fun initViews() {
        mTitle = findViewById(R.id.movies_details_title)
        mReleaseDate = findViewById(R.id.movies_details_date)
        mScore = findViewById(R.id.movies_details_score)
        mOverview = findViewById(R.id.movies_details_body_overview)
        mBanner = findViewById(R.id.movies_details_image_banner)
    }

}