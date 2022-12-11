package com.raminabbasiiii.movies.ui.movie.details

import android.util.Log
import androidx.lifecycle.*
import com.example.room.domain.usecase.InputData
import com.example.room.domain.usecase.MovieDetails_UseCase
import com.raminabbasiiii.movies.domain.entities.MovieDetails
import com.raminabbasiiii.movies.domain.repository.Repository
import com.raminabbasiiii.movies.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel
@Inject
constructor(
    private val moviedetailsUsecase: MovieDetails_UseCase
): ViewModel() {

    private val _movieDetails : MutableLiveData<Resource<MovieDetails>> = MutableLiveData()
    val movieDetails : LiveData<Resource<MovieDetails>> = _movieDetails
    private val TAG :String="MovieDetailsViewModel"



    /*init {
        getMovieDetails(movieId)
    }*/

    fun setMovieId(movieId: Int) {
        getMovieDetails(movieId)
    }

    private fun getMovieDetails(movieId: Int)   {
        viewModelScope.launch {

            moviedetailsUsecase.execute(InputData(movieId)).fold(
                {
                    Log.d(TAG, "getMovieDetails: error ${it.message}")

                },
                {
                    Resource.success(it)
                    _movieDetails.postValue(Resource.success(it))


                }
            )
        }
    }
}