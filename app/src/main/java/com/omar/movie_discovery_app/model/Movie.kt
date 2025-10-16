package com.omar.movie_discovery_app.model

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val id: Int,
    val title: String,
    val overview: String? = "",
    val poster_path: String? = null,
    val vote_average: Double? = 0.0,
    val release_date: String? = ""
) {
    val imageUrl: String
        get() = "https://image.tmdb.org/t/p/w500$poster_path"
}
