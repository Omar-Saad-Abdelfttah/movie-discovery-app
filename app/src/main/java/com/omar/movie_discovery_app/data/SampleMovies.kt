//package com.omar.movie_discovery_app.data

import com.omar.movie_discovery_app.model.Movie
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.omar.movie_discovery_app.navigation.NavigationGraph
//val sampleMovies = listOf(
// Movie(1, "Oppenheimer", "https://image.tmdb.org/t/p/w500/8Gxv8gSFCU0XGDykEG1cmV1m2j7.jpg"),
//Movie(2, "Barbie", "https://image.tmdb.org/t/p/w500/iuFNMS8U5cb6xfzi51Dbkovj7vM.jpg"),
//Movie(3, "John Wick 4", "https://image.tmdb.org/t/p/w500/vZloFAK7NmvMGKE7VkF5UHaz0I.jpg"),
// Movie(4, "Dune: Part Two", "https://image.tmdb.org/t/p/w500/1pdfLvkbY9ohJlCjQH2CZjjYVvJ.jpg"),
// Movie(5, "Spider-Man: Across the Spider-Verse", "https://image.tmdb.org/t/p/w500/8Vt6mWEReuy4Of61Lnj5Xj704m8.jpg"),
// Movie(6, "Avatar: The Way of Water", "https://image.tmdb.org/t/p/w500/t6HIqrRAclMCA60NsSmeqe9RmNV.jpg"),
// Movie(7, "Guardians of the Galaxy Vol. 3", "https://image.tmdb.org/t/p/w500/r2J02Z2OpNTctfOSN1Ydgii51I3.jpg"),
// Movie(8, "Mission: Impossible – Dead Reckoning", "https://image.tmdb.org/t/p/w500/NNxYkU70HPurnNCSiCjYAmacwm.jpg")
