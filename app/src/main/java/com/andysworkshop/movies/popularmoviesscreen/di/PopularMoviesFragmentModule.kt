package com.andysworkshop.movies.popularmoviesscreen.di

import com.andysworkshop.movies.di.ScreensModule
import com.andysworkshop.movies.popularmoviesscreen.PopularMoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PopularMoviesFragmentModule {
    @ContributesAndroidInjector ()
    abstract fun contributeFragmentAndroidInjector(): PopularMoviesFragment

}