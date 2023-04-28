package com.example.tmdb_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.tmdb_api.Factory.TMDB_Factory
import com.example.tmdb_api.Repository.PopularMoviesRepository
import com.example.tmdb_api.ViewModel.TMDB_ViewModel
import com.example.tmdb_api.databinding.ActivityTmdbDataDisplayBinding

class TMDB_DATA_Display_Activity : AppCompatActivity() {
    lateinit var binding: ActivityTmdbDataDisplayBinding

    lateinit var factory: TMDB_Factory
    lateinit var viewModel: TMDB_ViewModel
   // lateinit var adapter: Album_Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this , R.layout.activity_tmdb_data_display)

       factory = TMDB_Factory(PopularMoviesRepository("4da2ce878649bbad5b1ad09442ef2095"))
       viewModel = ViewModelProvider(this, factory)[TMDB_ViewModel::class.java]
       binding.lifecycleOwner = this

       viewModel.getPopularMovie()
    }
}