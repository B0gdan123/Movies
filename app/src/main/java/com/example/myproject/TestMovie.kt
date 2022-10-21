package com.example.myproject

import com.example.myproject.data.Result

data class TestMovie(
    val page: Int,
    val results: List<Result>,
    val totalPages: Int,
    val totalResults: Int
)