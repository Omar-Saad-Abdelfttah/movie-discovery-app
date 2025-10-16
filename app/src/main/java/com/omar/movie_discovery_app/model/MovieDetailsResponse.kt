package com.omar.movie_discovery_app.model

import com.google.gson.annotations.SerializedName

data class MovieDetailsResponse(
    val id: Int,
    val title: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("vote_average") val rating: Double,
    @SerializedName("runtime") val runtime: Int?,
    @SerializedName("release_date") val releaseDate: String?
) {
    val posterUrl: String
        get() = "https://image.tmdb.org/t/p/w500${posterPath ?: ""}"

    val backdropUrl: String
        get() = "https://image.tmdb.org/t/p/w780${backdropPath ?: ""}"
}
