package com.example.tmdb_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.tmdb_api.Factory.TMDB_Factory
import com.example.tmdb_api.Model.PopularMovies_Model
import com.example.tmdb_api.Repository.PopularMoviesRepository
import com.example.tmdb_api.RoomDB.Dao_movie_data_Api
import com.example.tmdb_api.RoomDB.MovieDatabase
import com.example.tmdb_api.ViewModel.TMDB_ViewModel
import com.example.tmdb_api.databinding.ActivityMovieDetailsBinding
import com.google.gson.Gson
import com.squareup.picasso.Picasso

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


        binding.title.text = student.title
        binding.originallanguage.text = student.original_language
        binding.popularitys.text = student.popularity
        binding.releaseDates.text = student.release_date
        binding.voteAverages.text = student.vote_average
        binding.voteCount.text = student.vote_count


    }
}