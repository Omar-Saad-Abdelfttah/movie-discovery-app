package com.omar.movie_discovery_app.model.API.Model

import com.omar.movie_discovery_app.model.UI.Models.Movie

fun ApiMovie.toMovie(): Movie {
    return Movie(
        id = this.id,
        title = this.title,
        posterUrl = "https://image.tmdb.org/t/p/w500${this.posterPath}"
    )
}
