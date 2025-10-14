package com.omar.movie_discovery_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.omar.movie_discovery_app.model.Movie
import com.omar.movie_discovery_app.ui.details.MovieDetailsScreen
import com.omar.movie_discovery_app.ui.screens.MovieGridScreen
import com.omar.movie_discovery_app.ui.screens.SearchScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieApp()
        }
    }
}

@Composable
fun MovieApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        // Home Screen
        composable("home") {
            MovieGridScreen(
                onMovieClick = { movie ->
                    navController.currentBackStackEntry
                        ?.savedStateHandle
                        ?.set("movie", movie)
                    navController.navigate("details")
                },
                onSearchClick = {
                    navController.navigate("search")
                }
            )
        }

        // Details Screen
        composable("details") {
            val movie = navController.previousBackStackEntry
                ?.savedStateHandle
                ?.get<Movie>("movie")

            if (movie != null) {
                MovieDetailsScreen(movie = movie, navController = navController)
            }
        }

        // Search Screen
        composable("search") {
            SearchScreen(
                navController = navController,
                onMovieClick = { movie ->
                    navController.currentBackStackEntry
                        ?.savedStateHandle
                        ?.set("movie", movie)
                    navController.navigate("details")
                }
            )
        }
    }
}