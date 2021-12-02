package com.andysworkshop.movies.popularmoviesscreen.usecases

import com.andysworkshop.movies.domain.IStore
import javax.inject.Inject

class RequestPopularMoviesUseCase @Inject constructor(
    private val store: IStore
) : IRequestPopularMoviesUseCase {
    override fun invoke() {
        store.requestPopularMoviesImages()
    }
}