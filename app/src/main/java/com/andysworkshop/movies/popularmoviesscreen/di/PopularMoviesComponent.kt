package com.andysworkshop.movies.popularmoviesscreen.di

import com.andysworkshop.movies.di.AppComponent
import com.andysworkshop.movies.popularmoviesscreen.PopularMoviesFragment
import dagger.Component
import javax.inject.Singleton

@PopularMoviesScope
@Component(
    modules = [PopularMoviesViewModelFactoryModule::class, PopularMoviesUseCasesModule::class],
    dependencies = [AppComponent::class]
)
interface PopularMoviesComponent {
    fun inject(popularMoviesFragment: PopularMoviesFragment)
}