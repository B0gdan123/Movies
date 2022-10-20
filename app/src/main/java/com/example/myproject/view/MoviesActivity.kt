package com.example.myproject.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject.*
import com.example.myproject.model.apis.ApiInterface
import com.example.myproject.view.adapters.CustomAdapter
import com.example.myproject.viewmodel.ItemsViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MoviesActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        Log.d("devlog", "in the Movies Activity")

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        // this creates a vertical layout Manager
        recyclerview.layoutManager = GridLayoutManager(this,2)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
//        for (i in 1..20) {
//            data.add(
//                ItemsViewModel(
//                    com.firebase.ui.auth.R.drawable.common_full_open_on_phone,
//                    "Item " + i
//                )
//            )
//        }

        // This will pass the ArrayList to our Adapter


        val apiInterface = ApiInterface.create().getMovie("e5f74869102e3b8ab1d63b79b819a3fe")

        apiInterface.enqueue(object : Callback<TestMovie>, CustomAdapter.ItemClickListener {

            override fun onResponse(call: Call<TestMovie>, response: Response<TestMovie>) {
                Log.d("deVlog", "OnResponse success ")

              val adapter = CustomAdapter(response.body()?.results?: arrayListOf(),this)
                recyclerview.adapter = adapter


            }

            override fun onFailure(call: Call<TestMovie>, t: Throwable) {
                Log.d("deVlog", "OnFailure success")
            }

            override fun onItemClick(id: Int) {
              val intent = Intent(this@MoviesActivity, MoviesDetailsVideo::class.java)
                intent.putExtra("id",id)
                startActivity(intent)
            }

        })


    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finishAffinity()

    }
}




