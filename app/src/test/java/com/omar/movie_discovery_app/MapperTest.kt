package com.omar.movie_discovery_app


import com.omar.movie_discovery_app.model.ApiMovie
import com.omar.movie_discovery_app.model.toMovie
import org.junit.Assert.assertEquals
import org.junit.Test


class MapperTest {

    @Test
    fun apiMovie_toMovie_mapsCorrectly() {

        val apiMovie = ApiMovie(

            id = 1,
            title = "Inception",
            overview = "A dream within a dream",
            poster_path = "/poster.jpg",
            vote_average = 8.8,
            release_date = "2010-07-16"

        )

        val movie = apiMovie.toMovie()

        assertEquals(apiMovie.id, movie.id)

        assertEquals(apiMovie.title, movie.title)

        assertEquals(apiMovie.overview, movie.overview)

        assertEquals(apiMovie.poster_path, movie.poster_path)

        assertEquals(apiMovie.vote_average, movie.vote_average!!, 0.0)

        assertEquals(apiMovie.release_date, movie.release_date)
    }
}














