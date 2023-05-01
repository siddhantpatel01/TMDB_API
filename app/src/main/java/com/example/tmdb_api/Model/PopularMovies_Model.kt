package com.example.tmdb_api.Model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class PopularMovies_Model(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0 ,
    var title: String = "",
    var poster_path:String="",
   var original_language : String = "",
    var popularity: String = "",
    var release_date : String = "",
    var vote_average : String = "",
    var vote_count : String = ""

)
