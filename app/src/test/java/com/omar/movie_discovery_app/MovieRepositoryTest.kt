package com.omar.movie_discovery_app

import com.omar.movie_discovery_app.data.network.ApiService
import com.omar.movie_discovery_app.model.*
import com.omar.movie_discovery_app.repository.MovieRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.*


class MovieRepositoryTest {
    private class TestableRepository(private val mockApi: ApiService) : MovieRepository() {
        suspend fun fetchMoviesWithMock() = mockApi .getPopularMovies("fake_key").results.map { it.toMovie() }
        suspend fun searchMoviesWithMock(query: String) = mockApi.searchMovies("fake_key", query).results.map { it.toMovie()}
    }

    private lateinit var mockApi: ApiService
    private lateinit var repository: TestableRepository

    @Before
    fun setup() {
        mockApi = mock()
        repository = TestableRepository(mockApi)
    }

    @Test
    fun fetchMovies_returnsMappedList() = runBlocking {

        val fakeApiMovies = listOf(
            ApiMovie(
                id = 1,
                title = "Inception",
                overview = "A dream within a dream",
                poster_path = "/poster.jpg",
                vote_average = 8.8,
                release_date = "2010-07-16"
            ),
            ApiMovie(
                id = 2,
                title = "Avatar",
                overview = "Pandora story",
                poster_path = "/avatar.jpg",
                vote_average = 7.9,
                release_date = "2009-12-18"

            )
        )

        val fakeResponse = ApiMovieResponse(
            page = 1,
            results = fakeApiMovies,
            totalPages = 1,
            totalResults = fakeApiMovies.size

        )


        whenever(mockApi
            .getPopularMovies(any()))
            .thenReturn(fakeResponse)

        val result = repository.fetchMoviesWithMock()

        assertEquals(2, result.size)

        assertEquals("Inception", result.first().title)

        assertEquals(8.8, result.first().vote_average ?: 0.0, 0.0)
    }

    @Test
    fun searchMovies_returnsFilteredResults() = runBlocking {
        val fakeApiMovies = listOf(
            ApiMovie(
                id = 3,
                title = "Joker",
                overview = "Dark comedy",
                poster_path = "/joker.jpg",
                vote_average = 8.5,
                release_date = "2019-10-04"
            )
        )

        val fakeResponse = ApiMovieResponse(
            page = 1,
            results = fakeApiMovies,
            totalPages = 1,
            totalResults = fakeApiMovies.size
        )


        whenever(mockApi.searchMovies(any(),eq("Joker"))).thenReturn(fakeResponse)

        val result = repository.searchMoviesWithMock("Joker")


        assertEquals(1, result.size)

        assertEquals("Joker", result.first().title)

        assertEquals(8.5, result.first().vote_average ?: 0.0, 0.0)
    }
}











