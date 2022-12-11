package com.raminabbasiiii.movies.domain.repository

import androidx.paging.PagingData
import arrow.core.Either
import com.example.room.data.network.Failure
import com.raminabbasiiii.movies.data.responeses.MovieDto
import com.raminabbasiiii.movies.domain.entities.Movie
import com.raminabbasiiii.movies.domain.entities.MovieDetails
import com.raminabbasiiii.movies.util.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun  getAllMovies(): Either<Failure, Flow<PagingData<Movie>>>
    suspend  fun getMovieDetails(movieId: Int): Either<Failure, MovieDetails>



}