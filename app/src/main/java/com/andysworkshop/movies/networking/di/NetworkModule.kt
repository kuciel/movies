package com.andysworkshop.movies.networking.di

import com.andysworkshop.movies.networking.INetwork
import com.andysworkshop.movies.networking.Network
import dagger.Binds
import dagger.Module

@Module
abstract class NetworkModule {
    @Binds
    abstract fun bindNetwork(network: Network): INetwork
}