package com.example.tmdb_api.Response

import android.graphics.Movie
import com.example.tmdb_api.Model.PopularMovies_Model
import com.example.tmdb_api.TMDB_API.Popular_Movies_Api
import com.google.gson.annotations.SerializedName

class PopularMovies_Response {
    @SerializedName("results")
    var movieList = ArrayList<PopularMovies_Model>()

}
