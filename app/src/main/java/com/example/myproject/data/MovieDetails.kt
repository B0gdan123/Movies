package com.example.myproject.data

import com.example.myproject.GenreX
import com.example.myproject.ProductionCompanyXX
import com.example.myproject.ProductionCountryXX
import com.example.myproject.SpokenLanguageXX

data class MovieDetails(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: Any,
    val budget: Int,
    val genres: List<GenreX>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: Any,
    val production_companies: List<ProductionCompanyXX>,
    val production_countries: List<ProductionCountryXX>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguageXX>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)