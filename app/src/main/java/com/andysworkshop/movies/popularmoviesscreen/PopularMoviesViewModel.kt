package com.andysworkshop.movies.popularmoviesscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andysworkshop.movies.popularmoviesscreen.data.PopularMoviesUIDataResult
import com.andysworkshop.movies.popularmoviesscreen.usecases.IObservePopularMoviesDataUseCase
import com.andysworkshop.movies.popularmoviesscreen.usecases.IRequestPopularMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class PopularMoviesViewModel @Inject constructor(
    private val requestPopularMoviesUseCase: IRequestPopularMoviesUseCase,
    private val observePopularMoviesData: IObservePopularMoviesDataUseCase
) : ViewModel() {

    fun fragmentResumed() {
        observePopularMoviesData.invoke(viewModelScope).onEach { popularMoviesUIDataResult ->
            when (popularMoviesUIDataResult) {
                is PopularMoviesUIDataResult.Success -> {
                    println("View model successfully got movies data: ${popularMoviesUIDataResult.value}")
                }
                is PopularMoviesUIDataResult.Error -> {
                    println("View model get movies data error: ${popularMoviesUIDataResult.message}")
                }
            }
        }
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)

        viewModelScope.launch(Dispatchers.IO) {
            requestPopularMoviesUseCase.invoke(TOP_NUMBER)
        }
    }

    companion object {
        const val TOP_NUMBER = 10
    }
}