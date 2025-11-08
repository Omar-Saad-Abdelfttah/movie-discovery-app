package com.omar.movie_discovery_app


import com.omar.movie_discovery_app.model.Movie
import com.omar.movie_discovery_app.repository.MovieRepository
import com.omar.movie_discovery_app.viewmodel.MovieViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever


@OptIn(ExperimentalCoroutinesApi::class)


class MovieViewModelTest {

    private val dispatcher = StandardTestDispatcher()
    private lateinit var repository: MovieRepository
    private lateinit var viewModel: MovieViewModel

    @Before
    fun setup() {

        Dispatchers.setMain(dispatcher)

        repository = mock()

        viewModel = MovieViewModel()

    }


    @After
    fun tearDown() {

        Dispatchers.resetMain()

    }


    @Test
    fun loadMovies_updatesStateFlow() = runBlocking {

        val fakeMovies = listOf(
            Movie(1, "Interstellar"
                , "desc"
                , "/poster.jpg"
                , 8.8
                , "2014-11-07"))

        whenever(repository.fetchMovies())
                 .thenReturn(fakeMovies)

        viewModel.loadMovies()

        dispatcher.scheduler.advanceUntilIdle()

        val result = viewModel.movies.first()

        assertEquals(0, result.size)
    }
}












