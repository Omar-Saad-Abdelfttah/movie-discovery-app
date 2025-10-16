package com.omar.movie_discovery_app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omar.movie_discovery_app.model.Movie
import com.omar.movie_discovery_app.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    private val repository = MovieRepository()

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> get() = _movies

    fun loadMovies() {
        viewModelScope.launch {
            try {
                _movies.value = repository.fetchMovies()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
