package com.andysworkshop.movies.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andysworkshop.movies.popularmoviesscreen.PopularMoviesViewModel
import javax.inject.Inject

class MoviesViewModelFactory @Inject constructor(): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass == PopularMoviesViewModel::class.java) {
            PopularMoviesViewModel() as T
        } else {
            modelClass.newInstance()
        }
    }

}