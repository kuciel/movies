package com.andysworkshop.movies.popularmoviesscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andysworkshop.movies.popularmoviesscreen.usecases.IRequestPopularMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class PopularMoviesViewModel @Inject constructor(
    private val requestPopularMoviesUseCase: IRequestPopularMoviesUseCase
) : ViewModel() {

    fun fragmentResumed() {
        viewModelScope.launch(Dispatchers.IO) {
            requestPopularMoviesUseCase.invoke()
        }
    }
}