package com.raminabbasiiii.movies.ui.movie.list

import android.util.Log
import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.room.domain.usecase.InputData
import com.example.room.domain.usecase.InputDataMovies
import com.example.room.domain.usecase.Movies_UseCase
import com.raminabbasiiii.movies.domain.entities.Movie
import com.raminabbasiiii.movies.domain.repository.Repository
import com.raminabbasiiii.movies.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class MovieListViewModel
@Inject
constructor(
    private val moviesUsecase: Movies_UseCase
): ViewModel(){

    private val _movies : MutableLiveData<PagingData<Movie>> = MutableLiveData()
    val movies : LiveData<PagingData<Movie>> = _movies
    private val TAG :String="MovieDetailsViewModel"


    init {
        getAllMovies()
    }

    fun getAllMovies() {
        viewModelScope.launch {
            moviesUsecase.execute(InputDataMovies()).fold(
                {
                    Log.d(TAG, "getMovieDetails: error ${it.message}")
                },
                {
                    Resource.success(it)
                    it.cachedIn(viewModelScope)
                    .collect {
                        _movies.value=it
                    }



                }
            )
        }
    }

}