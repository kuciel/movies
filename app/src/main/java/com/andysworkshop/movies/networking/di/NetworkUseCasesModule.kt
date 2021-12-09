package com.andysworkshop.movies.networking.di

import com.andysworkshop.movies.domain.usecases.IRequestMovieDetailStoreUseCase
import com.andysworkshop.movies.domain.usecases.IRequestPopularMoviesStoreUseCase
import com.andysworkshop.movies.networking.usecases.RequestMovieDetailUseCase
import com.andysworkshop.movies.networking.usecases.RequestPopularMoviesUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class NetworkUseCasesModule {
    @Binds
    abstract fun bindRequestPopularMoviesUseCase(requestPopularMoviesUseCase: RequestPopularMoviesUseCase): IRequestPopularMoviesStoreUseCase

    @Binds
    abstract fun bindRequestMovieDetailUseCase(requestMovieDetailUseCase: RequestMovieDetailUseCase): IRequestMovieDetailStoreUseCase
}