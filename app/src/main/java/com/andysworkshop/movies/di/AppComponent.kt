package com.andysworkshop.movies.di

import android.app.Application
import com.andysworkshop.movies.MoviesApplication
import com.andysworkshop.movies.domain.di.StoreModule
import com.andysworkshop.movies.popularmoviesscreen.di.PopularMoviesFragmentModule
import com.andysworkshop.movies.popularmoviesscreen.di.PopularMoviesUseCasesModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    PopularMoviesFragmentModule::class,
    ScreensModule::class,
    StoreModule::class,
    PopularMoviesUseCasesModule::class
])

interface AppComponent : AndroidInjector<MoviesApplication> {
    fun inject(application: Application)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun applicationBind(application: Application): Builder
    }
}