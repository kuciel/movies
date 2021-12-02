package com.andysworkshop.movies.networking.di

import com.andysworkshop.movies.domain.usecases.IRequestPopularMoviesUseCase
import com.andysworkshop.movies.networking.usecases.RequestPopularMoviesUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class NetworkUseCasesModule {
    @Binds
    abstract fun bindRequestPopularMoviesUseCase(requestPopularMoviesUseCase: RequestPopularMoviesUseCase): IRequestPopularMoviesUseCase
}