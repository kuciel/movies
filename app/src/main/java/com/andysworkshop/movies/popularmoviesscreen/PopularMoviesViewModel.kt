package com.andysworkshop.movies.popularmoviesscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andysworkshop.movies.popularmoviesscreen.data.PopularMoviesUIData
import com.andysworkshop.movies.popularmoviesscreen.data.PopularMoviesUIDataResult
import com.andysworkshop.movies.popularmoviesscreen.usecases.IObservePopularMoviesDataUseCase
import com.andysworkshop.movies.popularmoviesscreen.usecases.IRequestPopularMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class PopularMoviesViewModel @Inject constructor(
    private val requestPopularMoviesUseCase: IRequestPopularMoviesUseCase,
    observePopularMoviesData: IObservePopularMoviesDataUseCase
) : ViewModel() {

    private val _moviesSharedFlow = MutableSharedFlow<List<PopularMoviesUIData>>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    private val _navigateMovieDetails = MutableStateFlow("")

    val moviesSharedFlow: SharedFlow<List<PopularMoviesUIData>>
    get() {
        return _moviesSharedFlow
    }

    val navigateMovieDetails: StateFlow<String> = _navigateMovieDetails

    init {
        observePopularMoviesData.invoke(viewModelScope).onEach { popularMoviesUIDataResult ->
            when (popularMoviesUIDataResult) {
                is PopularMoviesUIDataResult.Success -> {
                    println("View model successfully got movies data: ${popularMoviesUIDataResult.value}")
                    _moviesSharedFlow.tryEmit(popularMoviesUIDataResult.value)
                }
                is PopularMoviesUIDataResult.Error -> {
                    println("View model get movies data error: ${popularMoviesUIDataResult.message}")
                }
            }
        }
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }

    fun fragmentResumed() {
        viewModelScope.launch(Dispatchers.IO) {
            requestPopularMoviesUseCase.invoke(TOP_NUMBER)
        }
    }

    fun onPosterClicked(movieId: String) {
        println("View model on poster clicked: $movieId")
        _navigateMovieDetails.tryEmit(movieId)
    }

    companion object {
        const val TOP_NUMBER = 10
    }
}