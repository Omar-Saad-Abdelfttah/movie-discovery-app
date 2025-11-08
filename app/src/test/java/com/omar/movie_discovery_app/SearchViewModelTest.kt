package com.omar.movie_discovery_app

import com.omar.movie_discovery_app.viewmodel.SearchViewModel
import com.omar.movie_discovery_app.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)

class SearchViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var viewModel: SearchViewModel

    @Before

    fun setup() {

        Dispatchers.setMain(testDispatcher)
        viewModel = SearchViewModel()
    }

    @After

    fun tearDown() {
        Dispatchers.resetMain()

    }


    @Test

    fun searchMovies_initialState_isEmpty() = runBlocking {
        val initialResults = viewModel.searchResults.first()

        assertTrue(initialResults.isEmpty())
    }

    @Test

    fun searchMovies_withBlankQuery_returnsEmptyList() = runBlocking {
        viewModel.searchMovies("")
        val results = viewModel.searchResults.first()

        assertTrue(results.isEmpty())
    }


    @Test

    fun movieData_structure_isCorrect() {

        val movie = Movie(
            id = 1,
            title = "The Matrix",
            overview = "A sci-fi simulation story",
            poster_path = "/poster.jpg",
            vote_average = 9.0,
            release_date = "1999-03-31"

        )

        assertEquals("The Matrix", movie.title)

        assertEquals(9.0, movie.vote_average ?: 0.0, 0.0)

        assertEquals("/poster.jpg", movie.poster_path)
    }
}
















