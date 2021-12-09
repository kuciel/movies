package com.andysworkshop.movies.moviedetailsscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andysworkshop.movies.moviedetailsscreen.usecases.IRequestMovieDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(
    private val requestMovieDetailsUseCase: IRequestMovieDetailUseCase
): ViewModel() {

    fun onCreateFragment(movieId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            requestMovieDetailsUseCase.invoke(movieId)
        }
    }
}