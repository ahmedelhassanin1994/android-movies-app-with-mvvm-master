package com.example.room.domain.usecase

import androidx.paging.PagingData
import arrow.core.Either
import com.example.room.data.network.Failure
import com.raminabbasiiii.movies.domain.entities.Movie
import com.raminabbasiiii.movies.domain.entities.MovieDetails
import com.raminabbasiiii.movies.domain.repository.Repository
import com.raminabbasiiii.movies.domain.usecase.BaseCase
import com.raminabbasiiii.movies.util.Resource
import kotlinx.coroutines.flow.Flow

class Movies_UseCase(private val repository : Repository) : BaseCase<InputDataMovies,  Flow<PagingData<Movie>>> {

    override suspend fun execute(input: InputDataMovies): Either<Failure, Flow<PagingData<Movie>>> {
       return repository.getAllMovies()
    }
}

 class  InputDataMovies(

)