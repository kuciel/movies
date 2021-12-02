package com.andysworkshop.movies.domain

import android.util.Log
import javax.inject.Inject

class Store @Inject constructor(): IStore {
    override fun requestPopularMoviesImages() {
        Log.d(TAG, "Requested popular movies from store")
    }

    companion object {
        private const val TAG = "Store"
    }
}