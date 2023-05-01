package com.example.tmdb_api.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.tmdb_api.Model.PopularMovies_Model
import com.example.tmdb_api.Model.Popular_Person_Model
import com.example.tmdb_api.Repository.Popular_Person_Repository
import com.example.tmdb_api.Repository.Popular_TVSHOW_Repository

class Popular_Person_View_Model(private val popularPersonRepository: Popular_Person_Repository): ViewModel() {
    fun getPopularperson(): LiveData<List<Popular_Person_Model>> {
        return popularPersonRepository.getPopularMovie()
    }

}
