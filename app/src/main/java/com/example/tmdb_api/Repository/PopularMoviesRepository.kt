package com.example.tmdb_api.Repository

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tmdb_api.Model.PopularMovies_Model
import com.example.tmdb_api.Response.PopularMovies_Response
import com.example.tmdb_api.RoomDB.Dao_movie_data_Api
import com.example.tmdb_api.TMDB_API.TMDB_RetroFit_Client
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularMoviesRepository(
    private val apiKey: String,
    private val moviedao: Dao_movie_data_Api
) {
    private var popularmoviesList: MutableLiveData<List<PopularMovies_Model>> = MutableLiveData()

    // private var popularmoviesList: LiveData<List<PopularMovies_Model>> = MutableLiveData<List<PopularMovies_Model>>()
    fun getPopularMovie(): MutableLiveData<List<PopularMovies_Model>> {
        val call = TMDB_RetroFit_Client.apiinterface.getpopularmovies(apiKey)
        call.enqueue(object : Callback<PopularMovies_Response> {
            override fun onResponse(
                call: Call<PopularMovies_Response>,
                response: Response<PopularMovies_Response>
            ) {
                if (response.isSuccessful) {
                    var body = response.body()
                    popularmoviesList.postValue(body?.movieList)
                    CoroutineScope(Dispatchers.Main).launch {
                        body?.movieList.let {
                            for (movie in it!!)
                                moviedao.saveMovieTODb(movie)
                        }
                    }
                    Log.d(TAG, "onResponse: $body")
                }
            }

            override fun onFailure(call: Call<PopularMovies_Response>, t: Throwable) {
                Log.d(TAG, "on Failure ${t.message} ")
            }

        })
        return popularmoviesList
    }

    fun getMoviefromlocalDB(): List<PopularMovies_Model> {
        return moviedao.getmoviefromlocaldb()
    }

    suspend fun getmovie(): LiveData<List<PopularMovies_Model>> {
        var movieListFromDB: List<PopularMovies_Model>? = null
        val job = CoroutineScope(Dispatchers.IO).async {
            movieListFromDB = getMoviefromlocalDB()
            return@async movieListFromDB
        }
//        var movieList_from_db = getMoviefromlocalDB()
        if (job.await()!!.isNotEmpty()) {
            popularmoviesList.postValue(movieListFromDB)
        } else {
            popularmoviesList = getPopularMovie()
        }
        return popularmoviesList
    }
}
