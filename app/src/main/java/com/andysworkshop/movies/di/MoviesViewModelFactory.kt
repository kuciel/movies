package com.andysworkshop.movies.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andysworkshop.movies.moviedetailsscreen.MovieDetailViewModel
import com.andysworkshop.movies.moviedetailsscreen.usecases.IRequestMovieDetailUseCase
import com.andysworkshop.movies.popularmoviesscreen.PopularMoviesViewModel
import com.andysworkshop.movies.popularmoviesscreen.usecases.IObservePopularMoviesDataUseCase
import com.andysworkshop.movies.popularmoviesscreen.usecases.IRequestPopularMoviesUseCase
import javax.inject.Inject

class MoviesViewModelFactory @Inject constructor(
    private val requestPopularMoviesUseCase: IRequestPopularMoviesUseCase,
    private val observePopularMoviesDataUseCase: IObservePopularMoviesDataUseCase,
    private val requestMovieDetailsUseCase: IRequestMovieDetailUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when(modelClass) {
            PopularMoviesViewModel::class.java ->
                PopularMoviesViewModel(requestPopularMoviesUseCase, observePopularMoviesDataUseCase) as T
            MovieDetailViewModel::class.java ->
                MovieDetailViewModel(requestMovieDetailsUseCase) as T
            else -> modelClass.newInstance()
        }
    }

}