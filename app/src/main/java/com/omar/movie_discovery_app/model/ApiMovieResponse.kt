package com.omar.movie_discovery_app.model

import com.google.gson.annotations.SerializedName
import com.omar.movie_discovery_app.model.ApiMovie

data class ApiMovieResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: List<ApiMovie>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)