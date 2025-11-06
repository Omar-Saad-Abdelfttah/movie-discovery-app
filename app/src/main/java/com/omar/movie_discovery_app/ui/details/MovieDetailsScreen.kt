package com.omar.movie_discovery_app.ui.details

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import com.omar.movie_discovery_app.model.MovieDetailsResponse
import com.omar.movie_discovery_app.repository.MovieRepository
import kotlinx.coroutines.launch
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.style.TextAlign
import com.omar.movie_discovery_app.model.CastMember


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MovieDetailsScreenById(
    navController: NavController,
    movieId: Int
) {
     val repository = remember { MovieRepository() }
    var movieDetails by remember { mutableStateOf<MovieDetailsResponse?>(null) }
    var movieCast by remember { mutableStateOf<List<CastMember>>(emptyList()) }

    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    LaunchedEffect(key1 = movieId) {
        coroutineScope.launch {
            try {
                val detailsResponse = repository.fetchMovieDetails(movieId)
                val castResponse = repository.getMovieCast(movieId)

                movieDetails = detailsResponse
                movieCast = castResponse
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0B1220))
    ) {
        AnimatedContent(
            targetState = movieDetails,
            transitionSpec = {
                slideInVertically(
                    initialOffsetY = { it / 2 },
                    animationSpec = tween(600)
                ) + fadeIn(animationSpec = tween(600)) with
                        fadeOut(animationSpec = tween(300))
            },
            label = "MovieDetailsAnimation"
        ) { details ->
            if (details == null) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = Color.White)
                }
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                        .padding(bottom = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box {
                        AsyncImage(
                            model = details.posterUrl,
                            contentDescription = details.title,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(320.dp)
                                .clip(MaterialTheme.shapes.medium)
                        )

                        IconButton(
                            onClick = { navController.popBackStack() },
                            modifier = Modifier
                                .padding(10.dp)
                                .align(Alignment.TopStart)
                                .background(
                                    Color.Black.copy(alpha = 0.5f),
                                    shape = MaterialTheme.shapes.small
                                )
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = details.title,

                        color = Color.White,

                        fontSize = 26.sp,



                          fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "⭐ ${"%.1f".format(details.rating)}/10",
                        color = Color(0xFFFFD700),
                        fontSize = 18.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Release Date: ${details.releaseDate ?: "Unknown"}",
                        color = Color(0xFFB0BEC5),

                        fontSize = 15.sp


                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = details.overview,
                        color = Color.White,
                        fontSize = 17.sp,
                        lineHeight = 23.sp,

                        modifier = Modifier.padding(horizontal = 16.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Cast:",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 16.dp)
                    )

                    LazyRow(


                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        items(movieCast) { castMember ->
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .padding(end = 12.dp)

                                    .width(100.dp)
                            ) {
                                AsyncImage(
                                    model = "https://image.tmdb.org/t/p/w500${castMember.profile_path}",
                                    contentDescription = castMember.name,
                                    modifier = Modifier
                                        .size(100.dp)
                                        .clip(RoundedCornerShape(12.dp))
                                )
                                Text(
                                    text = castMember.name,
                                    color = Color.White,

                                    fontSize = 13.sp,

                                    maxLines = 1
                                )
                            }
                        }
                    }

                }
            }
        }
    }
}
