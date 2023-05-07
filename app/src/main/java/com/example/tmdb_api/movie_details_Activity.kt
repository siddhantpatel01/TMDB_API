package com.example.tmdb_api

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.tmdb_api.Factory.TMDB_Factory
import com.example.tmdb_api.Model.PopularMovies_Model
import com.example.tmdb_api.Repository.PopularMoviesRepository
import com.example.tmdb_api.RoomDB.MovieDatabase
import com.example.tmdb_api.ViewModel.TMDB_ViewModel
import com.example.tmdb_api.databinding.ActivityMovieDetailsBinding
import com.google.gson.Gson


class movie_details_Activity : AppCompatActivity() {

    lateinit var binding: ActivityMovieDetailsBinding
    private lateinit var viewModel:TMDB_ViewModel
    lateinit var Factory: TMDB_Factory
    lateinit var student: PopularMovies_Model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details)
        Factory = TMDB_Factory(PopularMoviesRepository("4da2ce878649bbad5b1ad09442ef2095", MovieDatabase.getDatabase(this).getmovieDao()))
        viewModel = ViewModelProvider(this, Factory)[TMDB_ViewModel::class.java]
        val tempIntent = intent
        student = Gson().fromJson(tempIntent.getStringExtra(Keys.movieobject), PopularMovies_Model::class.java)

        val urlpath = "https://image.tmdb.org/t/p/w500//${student.poster_path}"
        //Picasso.get().load(student.poster_path).into(binding.poster)
        Glide.with(this).load(urlpath)
            .placeholder(R.drawable.baseline_person_24)
            .error(R.drawable.ic_launcher_foreground)
            .into(binding.poster)


        var movieName = student.title
        var movie_Language = student.original_language
        var popularity = student.popularity
        var releaseDate = student.release_date
        var voteAverages = student.vote_average
        var votecount  = student.vote_count
        binding.title.text = "Movie Name :  $movieName"
        binding.originallanguage.text = "Language : $movie_Language"
        binding.popularitys.text = "Popularity : $popularity"
        binding.releaseDates.text = "Release Date : $releaseDate"
        binding.voteAverages.text = "Rating : $voteAverages"
        binding.voteCount.text = "Vote : $votecount"


    }


}