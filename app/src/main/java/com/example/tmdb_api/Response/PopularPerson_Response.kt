package com.example.tmdb_api.Response

import com.example.tmdb_api.Model.Popular_TVSHOW_Model
import com.google.gson.annotations.SerializedName

class PopularPerson_Response {
    @SerializedName("results")
    var personList = ArrayList<Popular_TVSHOW_Model>()

}
