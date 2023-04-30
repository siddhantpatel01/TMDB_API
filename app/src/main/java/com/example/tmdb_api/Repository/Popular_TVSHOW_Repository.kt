package com.example.tmdb_api.Repository

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.tmdb_api.Model.Popular_TVSHOW_Model
import com.example.tmdb_api.Response.PopularPerson_Response
import com.example.tmdb_api.TMDB_API.TMDB_RetroFit_Client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Popular_TVSHOW_Repository(private val apiKey: String) {

    private var popularTVSHOWList : MutableLiveData<List<Popular_TVSHOW_Model>> = MutableLiveData()
    fun getPopularPerson(): MutableLiveData<List<Popular_TVSHOW_Model>> {
        val call = TMDB_RetroFit_Client.apiinterface_person.getpopularTVSHOW(apiKey)
        call.enqueue(object : Callback<PopularPerson_Response> {
            override fun onResponse(
                call: Call<PopularPerson_Response>,
                response: Response<PopularPerson_Response>
            ) {
           if (response.isSuccessful) {
                    var body = response.body()
                    popularTVSHOWList.postValue(body?.personList)
                    Log.d(ContentValues.TAG, "onResponse: $body")
                }
            }
            override fun onFailure(call: Call<PopularPerson_Response>, t: Throwable) {
                Log.d(ContentValues.TAG, "on Failure ${t.message} ")
            }
        })
        return popularTVSHOWList
    }

}

