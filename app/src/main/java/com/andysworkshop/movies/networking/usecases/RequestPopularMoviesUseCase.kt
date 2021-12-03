package com.andysworkshop.movies.networking.usecases

import com.andysworkshop.movies.domain.usecases.IRequestPopularMoviesUseCase
import com.andysworkshop.movies.networking.INetwork
import javax.inject.Inject

class RequestPopularMoviesUseCase @Inject constructor(
    private val network: INetwork
) : IRequestPopularMoviesUseCase {
    override suspend fun invoke() {
        network.requestPopularMoviesImages()
    }
}