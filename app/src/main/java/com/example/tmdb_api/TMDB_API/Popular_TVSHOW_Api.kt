package com.example.tmdb_api.TMDB_API
import com.example.tmdb_api.Response.PopularTVSHOW_Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Popular_TVSHOW_Api {
    @GET("/3/tv/popular")
    fun getpopularTVSHOW(@Query("api_key")apiKey : String): Call<PopularTVSHOW_Response>
}