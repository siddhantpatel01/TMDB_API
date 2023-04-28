package com.example.tmdb_api.TMDB_API

import com.example.tmdb_api.Response.PopularMovies_Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Popular_Movies_Api {
    @GET("/3/movie/popular")
    fun getpopularmovies(@Query("api_key")apiKey : String): Call<PopularMovies_Response>

}