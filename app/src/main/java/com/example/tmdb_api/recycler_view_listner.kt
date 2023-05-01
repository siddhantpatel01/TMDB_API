package com.example.tmdb_api

import com.example.tmdb_api.Model.PopularMovies_Model

interface recycler_view_listner {
    fun onItemClick(position: Int, moviesModel: PopularMovies_Model)
}