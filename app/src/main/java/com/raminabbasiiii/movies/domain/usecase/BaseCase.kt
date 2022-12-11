package com.raminabbasiiii.movies.domain.usecase

import arrow.core.Either
import com.example.room.data.network.Failure

interface BaseCase<In,Out> {
     suspend fun execute(input: In): Either<Failure, Out>

}