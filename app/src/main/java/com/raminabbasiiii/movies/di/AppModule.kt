package com.raminabbasiiii.movies.di

import com.example.room.domain.usecase.MovieDetails_UseCase
import com.example.room.domain.usecase.Movies_UseCase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.raminabbasiiii.movies.data.data_source.RemoteDataSource
import com.raminabbasiiii.movies.data.data_source.RemoteDataSourceImplementer
import com.raminabbasiiii.movies.data.network.Api
import com.raminabbasiiii.movies.domain.repository.Repository
import com.raminabbasiiii.movies.data.repository.MovieRepositoryImpl
import com.raminabbasiiii.movies.ui.movie.details.MovieDetailsViewModel
import com.raminabbasiiii.movies.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(gsonBuilder: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
    }

    @Singleton
    @Provides
    fun provideApiService(retrofitBuilder: Retrofit.Builder): Api {
        return retrofitBuilder
            .build()
            .create(Api::class.java)
    }

    @Singleton
    @Provides
    fun provideRemoteDataSource(api: Api
    ) = RemoteDataSourceImplementer(api) as RemoteDataSource


    @Singleton
    @Provides
    fun provideMovieRepository(
        remoteDataSource: RemoteDataSource
    ) = MovieRepositoryImpl(remoteDataSource) as Repository


    @Singleton
    @Provides
    fun provideMovieDetails_Usecase(
        repository: Repository
    ) = MovieDetails_UseCase(repository)

    @Singleton
    @Provides
    fun provideMovies_Usecase(
        repository: Repository
    ) = Movies_UseCase(repository)


//    @Singleton
//    @Provides
//    fun provideViewModel(
//        useCase: MovieDetails_UseCase
//    ) = MovieDetailsViewModel(useCase)

    /*@Singleton
    @Provides
    fun provideMovieRepository(
        api: Api
    ): MovieRepository{
        return MovieRepositoryImpl(api)
    }*/

}