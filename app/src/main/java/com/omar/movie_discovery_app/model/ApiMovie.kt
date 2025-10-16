package com.omar.movie_discovery_app.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiMovie(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String?,
    val vote_average: Double,
    val release_date: String
)
