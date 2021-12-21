package com.andysworkshop.movies.moviedetailsscreen.di

import com.andysworkshop.movies.di.AppComponent
import com.andysworkshop.movies.domain.di.StoreModule
import com.andysworkshop.movies.moviedetailsscreen.MovieDetailFragment
import com.andysworkshop.movies.networking.di.NetworkModule
import com.andysworkshop.movies.networking.di.NetworkUseCasesModule
import dagger.Component

@MovieDetailScope
@Component(
    modules = [MovieDetailsViewModelFactoryModule::class, MovieDetailUseCasesModule::class],
    dependencies = [AppComponent::class]
)

interface MovieDetailComponent {
    fun inject(movieDetailsFragment: MovieDetailFragment) {
    }
}