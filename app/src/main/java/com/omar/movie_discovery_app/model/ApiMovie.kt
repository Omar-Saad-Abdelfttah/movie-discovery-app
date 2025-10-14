package com.omar.movie_discovery_app.model

import com.google.gson.annotations.SerializedName

data class ApiMovie(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("release_date") val releaseDate: String
)