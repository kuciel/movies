package com.andysworkshop.movies.domain.usecases

import com.andysworkshop.movies.domain.data.PopularMoviesRequestResult

interface IRequestPopularMoviesUseCase {
    suspend fun invoke(): PopularMoviesRequestResult
}