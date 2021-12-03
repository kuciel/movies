package com.andysworkshop.movies.domain

interface IStore {
    suspend fun requestPopularMoviesImages()
}