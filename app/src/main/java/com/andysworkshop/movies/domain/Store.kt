package com.andysworkshop.movies.domain

import android.util.Log
import com.andysworkshop.movies.domain.usecases.IRequestPopularMoviesUseCase
import javax.inject.Inject

class Store @Inject constructor(
    private val requestPopularMoviesUseCase: IRequestPopularMoviesUseCase
) : IStore {
    override suspend fun requestPopularMoviesImages() {
        Log.d(TAG, "Requested popular movies from store")
        requestPopularMoviesUseCase.invoke()
    }

    companion object {
        private const val TAG = "Store"
    }
}