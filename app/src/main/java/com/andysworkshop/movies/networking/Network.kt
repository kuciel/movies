package com.andysworkshop.movies.networking

import android.util.Log
import com.andysworkshop.movies.domain.data.MovieData
import com.andysworkshop.movies.domain.data.PopularMoviesRequestResult
import javax.inject.Inject

class Network @Inject constructor(
    private val retrofitApiInterface: IRetrofitApiInterface
) : INetwork {

    override suspend fun requestPopularMoviesImages(): PopularMoviesRequestResult {
        return try {
            PopularMoviesRequestResult.Success(
                retrofitApiInterface.getPopularMovies().results.map {
                    MovieData(
                        id = it.id,
                        popularity = it.popularity,
                        posterPath = it.posterPath
                    )
                }
            )
        } catch (error: Throwable) {
            PopularMoviesRequestResult.Error(error.message ?: "Unknown error")
        }
    }

    companion object {
        private const val TAG = "Network"
    }
}