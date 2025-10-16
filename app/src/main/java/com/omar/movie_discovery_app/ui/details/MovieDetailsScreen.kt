package com.omar.movie_discovery_app.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.omar.movie_discovery_app.model.Movie
import com.omar.movie_discovery_app.model.MovieDetailsResponse
import com.omar.movie_discovery_app.repository.MovieRepository
import kotlinx.coroutines.launch
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

@Composable
fun MovieDetailsScreen(
    movie: Movie,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val repository = remember { MovieRepository() }
    var details by remember { mutableStateOf<MovieDetailsResponse?>(null) }
    val coroutineScope = rememberCoroutineScope()
    val backgroundColor = Color(0xFF0B1220)

    LaunchedEffect(movie.id) {
        coroutineScope.launch {
            try {
                details = repository.fetchMovieDetails(movie.id)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    Surface(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        if (details == null) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = Color.White)
            }
        } else {
            val movieDetails = details!!
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box {
                    AsyncImage(
                        model = movieDetails.posterUrl,
                        contentDescription = "${movie.title} poster",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(320.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Crop
                    )

                    IconButton(
                        onClick = { navController.popBackStack() },
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.TopStart)
                            .background(Color.Black.copy(alpha = 0.6f), RoundedCornerShape(50))
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = movieDetails.title,
                    color = Color.White,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "⭐️ ${movieDetails.rating}/10",
                    color = Color(0xFFFFD700),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Release Date: ${movieDetails.releaseDate ?: "Unknown"}",
                    color = Color.LightGray,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = movieDetails.overview,
                    color = Color.White,
                    fontSize = 16.sp,
                    lineHeight = 22.sp
                )
            }
        }
    }
}