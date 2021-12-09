package com.andysworkshop.movies.moviedetailsscreen.di

import com.andysworkshop.movies.moviedetailsscreen.usecases.IRequestMovieDetailUseCase
import com.andysworkshop.movies.moviedetailsscreen.usecases.RequestMovieDetailsUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class MovieDetailUseCasesModule {
    @Binds
    abstract fun bindRequestMovieDetailsUseCase(
        requestMovieDetailUseCase: RequestMovieDetailsUseCase
    ): IRequestMovieDetailUseCase
}