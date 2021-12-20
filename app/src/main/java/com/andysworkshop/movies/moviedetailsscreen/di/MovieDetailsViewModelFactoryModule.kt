package com.andysworkshop.movies.moviedetailsscreen.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andysworkshop.movies.moviedetailsscreen.MovieDetailViewModel
import com.andysworkshop.movies.moviedetailsscreen.usecases.IObserverMovieDetailUseCase
import com.andysworkshop.movies.moviedetailsscreen.usecases.IRequestMovieDetailUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class MovieDetailsViewModelFactoryModule {
    @Provides
    @MovieDetailScope
    fun provideViewModelFactory(
        requestMovieDetailsUseCase: IRequestMovieDetailUseCase,
        observerMovieDetailUseCase: IObserverMovieDetailUseCase
    ): ViewModelProvider.Factory {
        return MovieDetailsViewModelFactoryModule.ViewModelFactory(
            requestMovieDetailsUseCase,
            observerMovieDetailUseCase
        )
    }

    class ViewModelFactory @Inject constructor(
        private val requestMovieDetailsUseCase: IRequestMovieDetailUseCase,
        private val observerMovieDetailUseCase: IObserverMovieDetailUseCase
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return when (modelClass) {
                MovieDetailViewModel::class.java ->
                    MovieDetailViewModel(
                        requestMovieDetailsUseCase,
                        observerMovieDetailUseCase
                    ) as T
                else -> modelClass.newInstance()
            }
        }
    }
}