package com.omar.movie_discovery_app.model

import com.omar.movie_discovery_app.model.ApiMovie

fun ApiMovie.toMovie(): Movie {
    return Movie(
        id = this.id,
        title = this.title,
        posterUrl = "https://image.tmdb.org/t/p/w500${this.posterPath}"
    )
}
