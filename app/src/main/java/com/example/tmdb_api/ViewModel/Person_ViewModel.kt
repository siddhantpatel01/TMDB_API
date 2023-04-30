package com.example.tmdb_api.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.tmdb_api.Model.Popular_TVSHOW_Model
import com.example.tmdb_api.Repository.Popular_TVSHOW_Repository

class Person_ViewModel(private val popularTVSHOWRepository: Popular_TVSHOW_Repository):ViewModel() {

    fun getPopularPerson(): LiveData<List<Popular_TVSHOW_Model>> {
        return popularTVSHOWRepository.getPopularPerson()
    }
}