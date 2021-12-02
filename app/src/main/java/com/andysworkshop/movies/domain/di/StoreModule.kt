package com.andysworkshop.movies.domain.di

import com.andysworkshop.movies.domain.IStore
import com.andysworkshop.movies.domain.Store
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class StoreModule {
    @Singleton
    @Binds
    abstract fun bindStore(store: Store): IStore
}