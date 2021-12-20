package com.andysworkshop.movies.popularmoviesscreen.di

import com.andysworkshop.movies.domain.di.StoreModule
import com.andysworkshop.movies.networking.di.NetworkModule
import com.andysworkshop.movies.networking.di.NetworkUseCasesModule
import com.andysworkshop.movies.popularmoviesscreen.PopularMoviesFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules = [
    PopularMoviesViewModelFactoryModule::class,
    PopularMoviesUseCasesModule::class,
    StoreModule::class,
    NetworkUseCasesModule::class,
    NetworkModule::class])
interface PopularMoviesComponent {
    fun inject(popularMoviesFragment: PopularMoviesFragment)
}