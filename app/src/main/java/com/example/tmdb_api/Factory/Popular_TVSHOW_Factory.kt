package com.example.tmdb_api.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdb_api.Repository.Popular_TVSHOW_Repository
import com.example.tmdb_api.ViewModel.tvshow_ViewModel


class Popular_TVSHOW_Factory(private val popularTVSHOWRepository: Popular_TVSHOW_Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(tvshow_ViewModel::class.java)){
            return tvshow_ViewModel(popularTVSHOWRepository) as T
        }
        throw IllegalArgumentException("Unknown class")
    }
}