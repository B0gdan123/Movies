package com.example.myproject

data class  TestingDataClass(
    val `data`: List<Data>,
    val page: Int,
    val perPage: Int,
    val support: Support,
    val total: Int,
    val totalPages: Int
)