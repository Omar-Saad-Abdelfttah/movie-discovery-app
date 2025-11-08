package com.omar.movie_discovery_app

import com.omar.movie_discovery_app.viewmodel.SearchViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Test

class SearchViewModelTest {

    @Test
    fun initialSearchResults_areEmpty() = runBlocking {
        val viewModel = SearchViewModel()
        val results = viewModel.searchResults.first()
        assertTrue(results.isEmpty())
    }

    @Test
    fun search_withBlankQuery_returnsEmptyList() = runBlocking {
        val viewModel = SearchViewModel()
        viewModel.searchMovies("")
        val results = viewModel.searchResults.first()
        assertTrue(results.isEmpty())
    }
}
