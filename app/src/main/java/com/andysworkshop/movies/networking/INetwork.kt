package com.andysworkshop.movies.networking

interface INetwork {
    suspend fun requestPopularMoviesImages()
}