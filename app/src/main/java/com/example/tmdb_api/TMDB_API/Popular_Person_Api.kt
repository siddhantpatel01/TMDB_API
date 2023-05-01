package com.example.tmdb_api.TMDB_API

import com.example.tmdb_api.Response.Popular_Person_Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Popular_Person_Api {
    @GET("/3/person/popular")
    fun getpopularperson(@Query("api_key")apiKey : String): Call<Popular_Person_Response>
}