package com.andysworkshop.movies.moviedetailsscreen.di

import com.andysworkshop.movies.moviedetailsscreen.MovieDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MovieDetailsModule {
    @MovieDetailScope
    @ContributesAndroidInjector(modules = [MovieDetailsViewModelFactoryModule::class, MovieDetailUseCasesModule::class])
    abstract fun contributeMovieDetailFragment(): MovieDetailFragment
}