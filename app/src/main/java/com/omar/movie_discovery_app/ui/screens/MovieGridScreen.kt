package com.omar.movie_discovery_app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.omar.movie_discovery_app.ui.components.MovieCard
import com.omar.movie_discovery_app.model.Movie
import com.omar.movie_discovery_app.data.sampleMovies

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieGridScreen(
    onMovieClick: (Movie) -> Unit,
    onSearchClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "Movies",
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge
                )
            },
            actions = {
                IconButton(onClick = { onSearchClick() }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.White
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFF101010)
            )
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(sampleMovies) { movie ->
                MovieCard(
                    movie = movie,
                    onClick = {
                        onMovieClick(movie)
                    }

                )
            }
        }
    }
}