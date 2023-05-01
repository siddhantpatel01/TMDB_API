package com.example.tmdb_api.Response

import com.example.tmdb_api.Model.Popular_TVSHOW_Model
import com.google.gson.annotations.SerializedName

class PopularTVSHOW_Response {
    @SerializedName("results")
    var TvShowList = ArrayList<Popular_TVSHOW_Model>()

}
