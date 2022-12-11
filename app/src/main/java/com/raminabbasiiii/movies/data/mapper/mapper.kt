package com.raminabbasiiii.movies.data.mapper

import com.raminabbasiiii.movies.data.responeses.MovieDto
import com.raminabbasiiii.movies.domain.entities.Movie
import com.raminabbasiiii.movies.domain.entities.MovieDetails

fun MovieDto.toMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        poster = poster,
        year = year,
        country = country,
        rating = rating,
        genres = genres,
        images = images
    )
}

fun MovieDto.toMovieDetails(): MovieDetails {
    return MovieDetails(
        id = id,
        title = title,
        poster = poster,
        year = year,
        country = country,
        rating = rating,
        rated = rated,
        released = released,
        runtime = runtime,
        director = director,
        writer = writer,
        actors = actors,
        plot = plot,
        awards = awards,
        votes = votes,
        genres = genres,
        images = images
    )
}
