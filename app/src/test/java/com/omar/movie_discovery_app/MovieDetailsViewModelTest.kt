package com.omar.movie_discovery_app


import com.omar.movie_discovery_app.viewmodel.MovieDetailsViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test



class MovieDetailsViewModelTest {

    @Test
    fun initialMovieDetails_areNull_andCastEmpty() = runBlocking {

        val viewModel = MovieDetailsViewModel()
        val details = viewModel.movieDetails.first()
        val cast = viewModel.movieCast.first()

        assertNull(details)

        assertTrue(cast.isEmpty())
    }
}













