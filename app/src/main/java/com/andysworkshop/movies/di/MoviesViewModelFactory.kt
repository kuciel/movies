package com.andysworkshop.movies.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andysworkshop.movies.popularmoviesscreen.PopularMoviesViewModel
import com.andysworkshop.movies.popularmoviesscreen.usecases.IRequestPopularMoviesUseCase
import javax.inject.Inject

class MoviesViewModelFactory @Inject constructor(
    private val requestPopularMoviesUseCase: IRequestPopularMoviesUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass == PopularMoviesViewModel::class.java) {
            PopularMoviesViewModel(requestPopularMoviesUseCase) as T
        } else {
            modelClass.newInstance()
        }
    }

}