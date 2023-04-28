package com.example.tmdb_api.ViewModel

import androidx.lifecycle.ViewModel
import com.example.tmdb_api.Repository.PopularMoviesRepository

class TMDB_ViewModel(
    private val popularMoviesRepository: PopularMoviesRepository
) : ViewModel() {
    fun getPopularMovie(){
        popularMoviesRepository.getPopularMovie()
    }
}
