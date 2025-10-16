package com.omar.movie_discovery_app.model

fun ApiMovie.toMovie(): Movie {
    return Movie(
        id = this.id,
        title = this.title,
        overview = this.overview,
        poster_path = this.poster_path,
        vote_average = this.vote_average,
        release_date = this.release_date
    )
}
