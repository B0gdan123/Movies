package com.example.myproject.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject.*
import com.example.myproject.data.MovieListDataClass
import com.example.myproject.model.apis.ApiInterface
import com.example.myproject.model.repository.MoviesDBRepository
import com.example.myproject.view.adapters.CustomAdapter
import com.example.myproject.viewmodel.MoviesViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.FieldPosition


class MoviesActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")

    private val mViewModel: MoviesViewModel = MoviesViewModel()

    private lateinit var mMoviesRecycler: RecyclerView
    private lateinit var mMoviesAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        initViews()
        initObservers()
        mViewModel.getMovies()
    }

    private fun initObservers() {
        mViewModel.apply {
            movies.observe(this@MoviesActivity) {
                mMoviesAdapter = CustomAdapter(it, this@MoviesActivity)
                mMoviesRecycler.adapter = mMoviesAdapter
            }
        }
    }

    private fun initViews() {
        mMoviesRecycler = findViewById<RecyclerView>(R.id.recyclerview)
        mMoviesRecycler.layoutManager = GridLayoutManager(this, 2)
    }



    fun onItemClick(position: Int) {
        val intent = Intent(this@MoviesActivity, MoviesDetailsVideoActivity::class.java)
        intent.putExtra("id", position)
        startActivity(intent)
    }
    override fun onBackPressed() {
        super.onBackPressed()
        this.finishAffinity()

    }
}




