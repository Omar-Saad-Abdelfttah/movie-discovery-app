package com.omar.movie_discovery_app

import com.omar.movie_discovery_app.viewmodel.MovieDetailsViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class MovieDetailsViewModelStateTest {

    @Test
    fun details_initialState_isNull_andCastEmpty() = runBlocking {
        val vm = MovieDetailsViewModel()
        // لو عندك flows بأسماء مختلفة عدّل الأسماء هنا بنفسها
        val details = vm.movieDetails.first()
        val cast = vm.movieCast.first()

        assertNull(details)
        assertTrue(cast.isEmpty())
    }
}
