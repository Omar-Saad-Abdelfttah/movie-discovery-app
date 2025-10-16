package com.omar.movie_discovery_app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.omar.movie_discovery_app.data.sampleMovies
import com.omar.movie_discovery_app.model.Movie

@Composable
fun SearchScreen(
    navController: NavController,
    movies: List<Movie> = sampleMovies,
    onMovieClick: (Movie) -> Unit
) {
    var query by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0D0D0D))
            .padding(16.dp)
    ) {
        Text(
            text = "Search",
            style = MaterialTheme.typography.headlineMedium.copy(color = Color.White),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            placeholder = { Text("Search", color = Color.Gray) },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.Gray)
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                focusedContainerColor = Color(0xFF1A1A1A),
                unfocusedContainerColor = Color(0xFF1A1A1A),
                cursorColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        val filteredMovies = if (query.isEmpty()) {
            movies
        } else {
            movies.filter { it.title.contains(query, ignoreCase = true) }
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(filteredMovies) { movie ->
                MovieItem(
                    movie = movie,
                    onClick = { onMovieClick(movie) }
                )
            }
        }
    }
}