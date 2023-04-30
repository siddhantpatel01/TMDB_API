package com.example.tmdb_api.Repository

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.tmdb_api.Model.PopularMovies_Model
import com.example.tmdb_api.Response.PopularMovies_Response
import com.example.tmdb_api.TMDB_API.TMDB_RetroFit_Client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularMoviesRepository(private val apiKey:String) {
    private var popularmoviesList: MutableLiveData<List<PopularMovies_Model>> = MutableLiveData()
    fun getPopularMovie(): MutableLiveData<List<PopularMovies_Model>> {
        val call = TMDB_RetroFit_Client.apiinterface.getpopularmovies(apiKey)
        call.enqueue(object : Callback<PopularMovies_Response> {
            override fun onResponse(
                call: Call<PopularMovies_Response>,
                response: Response<PopularMovies_Response>
            ) {
                if (response.isSuccessful) {
                    var body = response.body()
                    popularmoviesList.postValue(body?.TVSHOWList)
                    Log.d(TAG, "onResponse: $body")
                }
            }

            override fun onFailure(call: Call<PopularMovies_Response>, t: Throwable) {
                Log.d(TAG,"on Failure ${t.message} ")
            }

        })
        return popularmoviesList
    }

}
