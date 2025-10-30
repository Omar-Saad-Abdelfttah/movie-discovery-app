package com.omar.movie_discovery_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.omar.movie_discovery_app.ui.details.MovieDetailsScreenById
import com.omar.movie_discovery_app.ui.screens.MovieGridScreen
import com.omar.movie_discovery_app.ui.screens.SearchScreen
import com.omar.movie_discovery_app.ui.screens.SplashScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {


        composable("splash") {
            SplashScreen(navController = navController)
        }

        composable("home") {
            MovieGridScreen(
                onMovieClick = { movie ->
                    navController.navigate("details/${movie.id}")
                },
                onSearchClick = {
                    navController.navigate("search")
                }
            )
        }

        composable("search") {
            SearchScreen(
                navController = navController,
                onMovieClick = { movie ->
                    navController.navigate("details/${movie.id}")
                }
            )
        }

        composable(
            route = "details/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt("movieId") ?: return@composable
            MovieDetailsScreenById(
                navController = navController,
                movieId = movieId
            )
        }
    }
}
