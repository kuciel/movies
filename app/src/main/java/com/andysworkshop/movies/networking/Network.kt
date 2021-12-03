package com.andysworkshop.movies.networking

import android.util.Log
import com.andysworkshop.movies.domain.data.MovieData
import javax.inject.Inject

class Network @Inject constructor(
    private val retrofitApiInterface: IRetrofitApiInterface): INetwork {

    override suspend fun requestPopularMoviesImages() {
        val result: List<MovieData>
        try {
            result = retrofitApiInterface.getPopularMovies().results.map {
                MovieData(
                    id = it.id,
                    popularity = it.popularity,
                    posterPath = it.posterPath
                )
            }
            println("Acquired popular movies data: $result")
        }
        catch (error: Throwable) {
            println("Error loading popular movies data: ${error.message}")
        }
    }

    companion object {
        private const val TAG = "Network"
    }
}