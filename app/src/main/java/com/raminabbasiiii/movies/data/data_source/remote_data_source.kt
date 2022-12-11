package com.raminabbasiiii.movies.data.data_source

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.raminabbasiiii.movies.data.mapper.toMovieDetails
import com.raminabbasiiii.movies.data.network.Api
import com.raminabbasiiii.movies.data.responeses.MovieDto
import com.raminabbasiiii.movies.data.responeses.MovieListResponse
import com.raminabbasiiii.movies.domain.entities.Movie
import com.raminabbasiiii.movies.domain.entities.MovieDetails
import com.raminabbasiiii.movies.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class RemoteDataSourceImplementer
@Inject
constructor(
    private val api: Api) : RemoteDataSource {

    override suspend fun getAllMovies(): Flow<PagingData<Movie>> = Pager(
    PagingConfig(1)
    ) {
        MoviePagingSource(api)
    }.flow

    override suspend fun getMovieDetails(movieId: Int):  MovieDto {

        return api.getMovieDetails(movieId)
    }



}
