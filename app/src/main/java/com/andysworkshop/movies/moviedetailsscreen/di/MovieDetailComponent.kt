package com.andysworkshop.movies.moviedetailsscreen.di

import com.andysworkshop.movies.domain.di.StoreModule
import com.andysworkshop.movies.moviedetailsscreen.MovieDetailFragment
import com.andysworkshop.movies.networking.di.NetworkModule
import com.andysworkshop.movies.networking.di.NetworkUseCasesModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules = [
    MovieDetailsViewModelFactoryModule::class,
    MovieDetailUseCasesModule::class,
    StoreModule::class,
    NetworkUseCasesModule::class,
    NetworkModule::class])

interface MovieDetailComponent {
    fun inject(movieDetailsFragment: MovieDetailFragment) {
    }
}