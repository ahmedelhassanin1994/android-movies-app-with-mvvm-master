package com.example.room.domain.usecase

import arrow.core.Either
import com.example.room.data.network.Failure
import com.raminabbasiiii.movies.domain.entities.MovieDetails
import com.raminabbasiiii.movies.domain.repository.Repository
import com.raminabbasiiii.movies.domain.usecase.BaseCase
import com.raminabbasiiii.movies.util.Resource
import kotlinx.coroutines.flow.Flow

class MovieDetails_UseCase(private val repository : Repository) : BaseCase<InputData, MovieDetails> {

    override suspend fun execute(input: InputData): Either<Failure,MovieDetails> {
       return repository.getMovieDetails(input.id)
    }
}

data class  InputData(
    val id :Int,

)