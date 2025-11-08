package com.omar.movie_discovery_app


import com.omar.movie_discovery_app.data.network.RetrofitInstance
import com.omar.movie_discovery_app.model.*
import com.omar.movie_discovery_app.repository.MovieRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class MovieRepositoryTest {

    private lateinit var repository: MovieRepository
    private val mockApi = mock<com.omar.movie_discovery_app.data.network.ApiService>()

    @Before


    fun setup() {


        val retrofitField = RetrofitInstance::class.java.getDeclaredField("api")

        retrofitField.isAccessible = true

        retrofitField.set(null, mockApi)

        repository = MovieRepository()
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

            )
            ,
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

        whenever(mockApi.
        getPopularMovies(Mockito.anyString())).thenReturn(fakeResponse)

        val result = repository.fetchMovies()

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

        whenever(mockApi.
        searchMovies(Mockito.anyString(), Mockito.eq("Joker")))
        .thenReturn(fakeResponse)

        val result = repository.searchMovies("Joker")

        assertEquals(1, result.size)

        assertEquals("Joker", result.first().title)


        assertEquals(8.5, result.first().vote_average ?: 0.0, 0.0)
    }
}













