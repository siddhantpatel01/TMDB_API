package com.example.tmdb_api.RoomDB

import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdb_api.Model.PopularMovies_Model

@Dao
interface Dao_movie_data_Api {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovieTODb(vararg movieList: PopularMovies_Model)

    //    @Query("SELECT * FROM PopularMovies_Model")
//    fun getmoviefromlocaldb():MutableLiveData<List<PopularMovies_Model>>
    @Query("SELECT * FROM PopularMovies_Model")
    fun getmoviefromlocaldb(): List<PopularMovies_Model>

}