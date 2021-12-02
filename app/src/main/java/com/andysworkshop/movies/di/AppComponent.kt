package com.andysworkshop.movies.di

import android.app.Application
import com.andysworkshop.movies.MoviesApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ScreensModule::class])

interface AppComponent : AndroidInjector<MoviesApplication> {
    fun inject(application: Application)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun applicationBind(application: Application): Builder
    }
}