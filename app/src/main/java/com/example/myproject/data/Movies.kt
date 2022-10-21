package com.example.myproject.data

import com.example.myproject.ProductionCompany
import com.example.myproject.ProductionCountries
import com.example.myproject.SpokenLanguage

data class Movies(
    val adult: Boolean,
    val backdropPath: String,
    val belongsToCollection: Any,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val productionCompanies: List<ProductionCompany>,
    val productionCountries: List<ProductionCountries>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)