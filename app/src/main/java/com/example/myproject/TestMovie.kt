package com.example.myproject

import com.example.myproject.data.Result

data class TestMovie(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)