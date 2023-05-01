package com.example.tmdb_api.Repository

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.tmdb_api.Model.Popular_Person_Model
import com.example.tmdb_api.Response.Popular_Person_Response
import com.example.tmdb_api.TMDB_API.TMDB_RetroFit_Client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Popular_Person_Repository(private val apiKey:String) {
    private var popularPersonList: MutableLiveData<List<Popular_Person_Model>> = MutableLiveData()
    fun getPopularMovie(): MutableLiveData<List<Popular_Person_Model>> {
        val call = TMDB_RetroFit_Client.apiinterface_person.getpopularperson(apiKey)
        call.enqueue(object : Callback<Popular_Person_Response> {
            override fun onResponse(
                call: Call<Popular_Person_Response>,
                response: Response<Popular_Person_Response>
            ) {
                if (response.isSuccessful) {
                    var body = response.body()
                    popularPersonList.postValue(body?.personList)
                    Log.d(ContentValues.TAG, "onResponse: $body")
                }
            }
            override fun onFailure(call: Call<Popular_Person_Response>, t: Throwable) {
                Log.d(ContentValues.TAG,"on Failure ${t.message} ")
            }
        })
        return popularPersonList
    }

}

