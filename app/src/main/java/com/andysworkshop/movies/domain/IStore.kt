package com.andysworkshop.movies.domain

import com.andysworkshop.movies.domain.data.PopularMoviesRequestResult
import kotlinx.coroutines.flow.SharedFlow

interface IStore {
    val popularMoviesData: SharedFlow<PopularMoviesRequestResult>

    suspend fun requestPopularMoviesImages(maxNumberOfMovies: Int)

    suspend fun requestMovieDetail(movieId: String)
}