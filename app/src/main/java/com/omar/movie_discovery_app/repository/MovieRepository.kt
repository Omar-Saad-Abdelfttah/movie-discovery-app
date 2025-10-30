package com.omar.movie_discovery_app.repository

import com.omar.movie_discovery_app.data.network.RetrofitInstance
import com.omar.movie_discovery_app.model.ApiMovie
import com.omar.movie_discovery_app.model.Movie
import com.omar.movie_discovery_app.model.MovieDetailsResponse
import com.omar.movie_discovery_app.model.toMovie

class MovieRepository {

    private val apiKey = "c72e576eec8cf631df3cf7cf01b5bff2"

    suspend fun fetchMovies(): List<Movie> {
        val apiMovies: List<ApiMovie> = RetrofitInstance.api
            .getPopularMovies(apiKey)
            .results

        return apiMovies.map { it.toMovie() }
    }
}