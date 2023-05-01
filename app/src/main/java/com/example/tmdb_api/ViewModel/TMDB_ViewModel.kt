package com.example.tmdb_api.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.tmdb_api.Model.PopularMovies_Model
import com.example.tmdb_api.Repository.PopularMoviesRepository

class TMDB_ViewModel(private val popularMoviesRepository: PopularMoviesRepository) : ViewModel() {
    fun getPopularMovie(): LiveData<List<PopularMovies_Model>> {
        return popularMoviesRepository.getPopularMovie()
    }

    suspend fun getMovie() : LiveData<List<PopularMovies_Model>>{
        return popularMoviesRepository.getmovie()
    }
}
