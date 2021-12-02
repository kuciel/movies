package com.andysworkshop.movies.networking

import android.util.Log
import javax.inject.Inject

class Network @Inject constructor(retrofitApiInterface: IRetrofitApiInterface): INetwork {
    override fun requestPopularMoviesImages() {
        Log.d(TAG, "Requesting popular movies from remote")
    }

    companion object {
        private const val TAG = "Network"
    }
}