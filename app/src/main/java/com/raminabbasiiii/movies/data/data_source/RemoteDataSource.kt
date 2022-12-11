package com.raminabbasiiii.movies.data.data_source

import androidx.paging.PagingData
import com.raminabbasiiii.movies.data.responeses.MovieDto
import com.raminabbasiiii.movies.domain.entities.Movie
import com.raminabbasiiii.movies.util.Resource
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun getAllMovies(): Flow<PagingData<Movie>>
    suspend fun getMovieDetails(movieId: Int): MovieDto
}