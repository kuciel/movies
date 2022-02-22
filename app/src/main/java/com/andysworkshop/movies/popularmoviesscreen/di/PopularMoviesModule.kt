package com.andysworkshop.movies.popularmoviesscreen.di

import com.andysworkshop.movies.popularmoviesscreen.PopularMoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PopularMoviesModule {
    @PopularMoviesScope
    @ContributesAndroidInjector(modules = [PopularMoviesViewModelFactoryModule::class, PopularMoviesUseCasesModule::class] )
    abstract fun contributePopularMoviesFragment(): PopularMoviesFragment
}