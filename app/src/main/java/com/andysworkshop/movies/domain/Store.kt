package com.andysworkshop.movies.domain

import android.util.Log
import com.andysworkshop.movies.domain.data.PopularMoviesRequestResult
import com.andysworkshop.movies.domain.usecases.IRequestPopularMoviesUseCase
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

class Store @Inject constructor(
    private val requestPopularMoviesUseCase: IRequestPopularMoviesUseCase
) : IStore {

    private val _popularMoviesData = MutableSharedFlow<PopularMoviesRequestResult>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    override val popularMoviesData: SharedFlow<PopularMoviesRequestResult>
        get() {
            return _popularMoviesData
        }

    override suspend fun requestPopularMoviesImages(maxNumberOfMovies: Int) {
        Log.d(TAG, "Requested popular movies from store")
        when (val popularMoviesResult = requestPopularMoviesUseCase.invoke()) {
            is PopularMoviesRequestResult.Success -> {
                popularMoviesResult.value.sortedBy { it.popularity }
                _popularMoviesData.tryEmit(PopularMoviesRequestResult.Success(
                    popularMoviesResult.value.sortedBy { it.popularity }
                        .subList(0, maxNumberOfMovies)).also {
                            println("Popular movies sorted and limited: $it")
                        }
                )
            }
            is PopularMoviesRequestResult.Error -> {
                _popularMoviesData.tryEmit(popularMoviesResult)
            }
        }
    }

    companion object {
        private const val TAG = "Store"
    }
}