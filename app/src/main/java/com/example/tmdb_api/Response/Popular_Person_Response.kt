package com.example.tmdb_api.Response

import com.example.tmdb_api.Model.PopularMovies_Model
import com.example.tmdb_api.Model.Popular_Person_Model
import com.google.gson.annotations.SerializedName

class Popular_Person_Response {
    @SerializedName("results")
    var personList = ArrayList<Popular_Person_Model>()
}