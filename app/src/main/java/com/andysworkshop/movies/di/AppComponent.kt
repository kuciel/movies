package com.andysworkshop.movies.di

import android.app.Application
import com.andysworkshop.movies.MoviesApplication
import com.andysworkshop.movies.domain.di.StoreModule
import com.andysworkshop.movies.moviedetailsscreen.di.MovieDetailFragmentModule
import com.andysworkshop.movies.moviedetailsscreen.di.MovieDetailUseCasesModule
import com.andysworkshop.movies.moviedetailsscreen.usecases.IObserverMovieDetailUseCase
import com.andysworkshop.movies.moviedetailsscreen.usecases.IRequestMovieDetailUseCase
import com.andysworkshop.movies.networking.di.NetworkModule
import com.andysworkshop.movies.networking.di.NetworkUseCasesModule
import com.andysworkshop.movies.popularmoviesscreen.di.PopularMoviesFragmentModule
import com.andysworkshop.movies.popularmoviesscreen.di.PopularMoviesUseCasesModule
import com.andysworkshop.movies.popularmoviesscreen.usecases.IObservePopularMoviesDataUseCase
import com.andysworkshop.movies.popularmoviesscreen.usecases.IRequestPopularMoviesUseCase
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        PopularMoviesFragmentModule::class,
        MovieDetailFragmentModule::class,
        ScreensModule::class,
        StoreModule::class,
        PopularMoviesUseCasesModule::class,
        MovieDetailUseCasesModule::class,
        NetworkUseCasesModule::class,
        NetworkModule::class
    ]
)

interface AppComponent : AndroidInjector<MoviesApplication> {
    fun inject(application: Application)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun applicationBind(application: Application): Builder
    }

    fun getIObserverMovieDetailsUseCase(): IObserverMovieDetailUseCase

    fun getIRequestMovieDetailUseCase(): IRequestMovieDetailUseCase

    fun getIObservePopularMoviesDataUseCase(): IObservePopularMoviesDataUseCase

    fun getIRequestPopularMoviesUseCase(): IRequestPopularMoviesUseCase
}