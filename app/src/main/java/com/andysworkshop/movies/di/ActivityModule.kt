package com.andysworkshop.movies.di

import com.andysworkshop.movies.MainActivity
import com.andysworkshop.movies.moviedetailsscreen.di.MovieDetailsModule
import com.andysworkshop.movies.popularmoviesscreen.PopularMoviesFragment
import com.andysworkshop.movies.popularmoviesscreen.di.PopularMoviesModule
import com.andysworkshop.movies.popularmoviesscreen.di.PopularMoviesScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [PopularMoviesModule::class, MovieDetailsModule::class])
    abstract fun contributeMainActivity(): MainActivity
}