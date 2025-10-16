package com.omar.movie_discovery_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.omar.movie_discovery_app.model.Movie
import com.omar.movie_discovery_app.ui.details.MovieDetailsScreen
import com.omar.movie_discovery_app.ui.screens.MovieGridScreen
import com.omar.movie_discovery_app.ui.screens.SearchScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

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

        composable("details") {
            val movie = navController.previousBackStackEntry
                ?.savedStateHandle
                ?.get<Movie>("movie")

            if (movie != null) {
                MovieDetailsScreen(movie = movie, navController = navController)
            }
        }

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