package com.andysworkshop.movies.di

import android.app.Application
import com.andysworkshop.movies.MoviesApplication
import com.andysworkshop.movies.domain.IStore
import com.andysworkshop.movies.domain.di.StoreModule
import com.andysworkshop.movies.networking.di.NetworkModule
import com.andysworkshop.movies.networking.di.NetworkUseCasesModule
import com.andysworkshop.movies.popularmoviesscreen.di.PopularMoviesModule
import com.andysworkshop.movies.popularmoviesscreen.di.PopularMoviesUseCasesModule
import com.andysworkshop.movies.popularmoviesscreen.di.PopularMoviesViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        StoreModule::class,
        NetworkUseCasesModule::class,
        NetworkModule::class,
        ActivityModule::class
    ]
)

interface AppComponent {
    fun inject(application: Application)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun applicationBind(application: Application): Builder
    }

    fun inject(app: MoviesApplication)
    fun getStore(): IStore
}