package com.example.tmdb_api.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdb_api.Repository.Popular_Person_Repository
import com.example.tmdb_api.Repository.Popular_TVSHOW_Repository
import com.example.tmdb_api.ViewModel.Popular_Person_View_Model
import com.example.tmdb_api.ViewModel.tvshow_ViewModel

class Popular_Person_Factory(private val popularPersonRepository: Popular_Person_Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(Popular_Person_View_Model::class.java)){
            return Popular_Person_View_Model(popularPersonRepository) as T
        }
        throw IllegalArgumentException("Unknown class")
    }
}