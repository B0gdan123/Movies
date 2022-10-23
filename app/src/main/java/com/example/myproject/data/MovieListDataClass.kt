package com.example.myproject.data

import com.example.myproject.data.DataMovie

data class MovieListDataClass(
    val page: Int,
    val results: List<DataMovie>,
    val total_pages: Int,
    val total_results: Int
)