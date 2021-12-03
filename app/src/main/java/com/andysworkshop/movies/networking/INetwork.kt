package com.andysworkshop.movies.networking

import com.andysworkshop.movies.domain.data.PopularMoviesRequestResult

interface INetwork {
    suspend fun requestPopularMoviesImages(): PopularMoviesRequestResult
}