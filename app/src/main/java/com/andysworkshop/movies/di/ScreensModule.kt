package com.andysworkshop.movies.di

import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides

@Module
class ScreensModule {
    @Provides
    fun provideViewModelFactory (): ViewModelProvider.Factory {
        return MoviesViewModelFactory()
    }
}