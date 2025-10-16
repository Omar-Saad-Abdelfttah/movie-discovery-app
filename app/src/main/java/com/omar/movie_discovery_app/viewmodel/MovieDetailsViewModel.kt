package com.omar.movie_discovery_app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omar.movie_discovery_app.model.MovieDetailsResponse
import com.omar.movie_discovery_app.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieDetailsViewModel : ViewModel() {

    private val repository = MovieRepository()

    private val _movieDetails = MutableStateFlow<MovieDetailsResponse?>(null)
    val movieDetails: StateFlow<MovieDetailsResponse?> get() = _movieDetails

    fun loadMovieDetails(movieId: Int) {
        viewModelScope.launch {
            try {
                val details = repository.fetchMovieDetails(movieId)
                _movieDetails.value = details
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
