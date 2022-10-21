package com.example.myproject.data

import com.example.myproject.GenreX
import com.example.myproject.ProductionOfCompany
import com.example.myproject.ProductionOfCountries
import com.example.myproject.SpokenOfLanguage

data class MovieDetails(
    val adult: Boolean,
    val backdropPath: String,
    val belongsToCollection: Any,
    val budget: Int,
    val genres: List<GenreX>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: Any,
    val productionCompanies: List<ProductionOfCompany>,
    val productionCountries: List<ProductionOfCountries>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<SpokenOfLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)