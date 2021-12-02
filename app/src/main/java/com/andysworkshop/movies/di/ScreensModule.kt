package com.andysworkshop.movies.di

import androidx.lifecycle.ViewModelProvider
import com.andysworkshop.movies.popularmoviesscreen.usecases.IRequestPopularMoviesUseCase
import dagger.Module
import dagger.Provides

@Module
class ScreensModule {
    @Provides
    fun provideViewModelFactory (requestPopularMoviesUseCase: IRequestPopularMoviesUseCase): ViewModelProvider.Factory {
        return MoviesViewModelFactory(requestPopularMoviesUseCase)
    }
}