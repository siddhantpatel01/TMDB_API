package com.example.tmdb_api.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdb_api.Repository.PopularMoviesRepository
import com.example.tmdb_api.ViewModel.TMDB_ViewModel

class TMDB_Factory(private val popularMoviesRepository: PopularMoviesRepository)  : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TMDB_ViewModel::class.java)){
            return TMDB_ViewModel(popularMoviesRepository) as T
        }
        throw IllegalArgumentException("Unknown class")
    }
}
