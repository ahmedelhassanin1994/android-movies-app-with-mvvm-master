package com.raminabbasiiii.movies.data.repository

import Network
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import arrow.core.Either
import com.example.room.data.network.Failure
import com.raminabbasiiii.movies.BaseApplication
import com.raminabbasiiii.movies.data.data_source.MoviePagingSource
import com.raminabbasiiii.movies.data.data_source.RemoteDataSource
import com.raminabbasiiii.movies.data.mapper.toMovieDetails
import com.raminabbasiiii.movies.data.network.Api
import com.raminabbasiiii.movies.data.network.ResponseMessage
import com.raminabbasiiii.movies.domain.repository.Repository
import com.raminabbasiiii.movies.domain.entities.Movie
import com.raminabbasiiii.movies.domain.entities.MovieDetails
import com.raminabbasiiii.movies.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import java.lang.Exception
import javax.inject.Inject

class MovieRepositoryImpl
@Inject
constructor(
    private val remoteDataSource: RemoteDataSource
    ): Repository {

    private val TAG="getMovieDetails";



    override suspend fun getAllMovies(): Either<Failure, Flow<PagingData<Movie>>>{

        if (Network.checkConnectivity(BaseApplication.applicationContext())) {

            try {
                return Either.Right(remoteDataSource.getAllMovies())
            }catch (e: Exception){
                return Either.Left(Failure(-1,e.message.toString()))

            }
        }else{
            return Either.Left(Failure(-1, ResponseMessage.SEND_TIMEOUT))

        }


    }






    /*override fun getMoviesByPage(page: Int): Flow<PagingData<Movie>> = Pager(
        PagingConfig(page)
    ) {
        MoviePagingSource(api)
    }.flow*/

    override suspend fun getMovieDetails(movieId: Int): Either<Failure, MovieDetails> {

        if (Network.checkConnectivity(BaseApplication.applicationContext())) {

            try {
//                Either.Right((Resource.loading(null)))
                 Either.Right((Resource.success(remoteDataSource.getMovieDetails(movieId).toMovieDetails())))
                return Either.Right(remoteDataSource.getMovieDetails(movieId).toMovieDetails())


            } catch (e: Exception) {
                return Either.Left(Failure(-1,e.message.toString()))
            }

        }else{
            return Either.Left(Failure(-1, ResponseMessage.SEND_TIMEOUT))


       }

    }


}














