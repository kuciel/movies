package com.andysworkshop.movies.moviedetailsscreen.di

import com.andysworkshop.movies.di.ScreensModule
import com.andysworkshop.movies.moviedetailsscreen.MovieDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MovieDetailFragmentModule {
    @ContributesAndroidInjector()
    abstract fun contributeFragmentAndroidInjector(): MovieDetailFragment
}