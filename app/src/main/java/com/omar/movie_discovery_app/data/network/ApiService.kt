package com.omar.movie_discovery_app.data.network

import com.omar.movie_discovery_app.model.ApiMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String
    ): ApiMovieResponse
}
