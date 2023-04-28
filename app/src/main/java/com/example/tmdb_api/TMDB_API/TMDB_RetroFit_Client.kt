package com.example.tmdb_api.TMDB_API

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val baseurl = "https://api.themoviedb.org/"
object TMDB_RetroFit_Client {
    val retofitClient: Retrofit.Builder by lazy {


        Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
    }
    val apiinterface:Popular_Movies_Api by lazy {
        retofitClient.build().create(Popular_Movies_Api::class.java)
    }
}