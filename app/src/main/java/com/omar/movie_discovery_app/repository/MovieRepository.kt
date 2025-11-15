package com.omar.movie_discovery_app.repository

import com.omar.movie_discovery_app.data.network.RetrofitInstance
import com.omar.movie_discovery_app.model.ApiMovie
import com.omar.movie_discovery_app.model.Movie
import com.omar.movie_discovery_app.model.CastMember
import com.omar.movie_discovery_app.model.CastResponse
import com.omar.movie_discovery_app.model.MovieDetailsResponse
import com.omar.movie_discovery_app.model.toMovie
import com.omar.movie_discovery_app.BuildConfig

open class MovieRepository {

    private val apiKey = BuildConfig.TMDB_API_KEY

    suspend fun fetchMovies(): List<Movie> {
        val apiMovies: List<ApiMovie> = RetrofitInstance.api
            .getPopularMovies(apiKey)
            .results

        return apiMovies.map { it.toMovie() }
    }

    suspend fun fetchMovieDetails(movieId: Int): MovieDetailsResponse {
        return RetrofitInstance.api.getMovieDetails(movieId, apiKey)
    }


    suspend fun searchMovies(query: String): List<Movie> {
        val response = RetrofitInstance.api.searchMovies(apiKey, query)
        return response.results.map { it.toMovie() }
    }


    suspend fun getMovieCast(movieId: Int): List<CastMember> {
        val response = RetrofitInstance.api.getMovieCast(movieId, apiKey)
        return response.cast
    }
}