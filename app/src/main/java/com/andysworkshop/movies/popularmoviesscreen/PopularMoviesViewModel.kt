package com.andysworkshop.movies.popularmoviesscreen

import androidx.lifecycle.ViewModel
import com.andysworkshop.movies.popularmoviesscreen.usecases.IRequestPopularMoviesUseCase
import javax.inject.Inject

class PopularMoviesViewModel @Inject constructor(
    private val requestPopularMoviesUseCase: IRequestPopularMoviesUseCase
): ViewModel() {

    fun fragmentResumed() {
        requestPopularMoviesUseCase.invoke()
    }
}