package com.example.tmdb_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.tmdb_api.Adapter_TMDB.Movie_Data_RecyclerView_Adapter
import com.example.tmdb_api.Factory.TMDB_Factory
import com.example.tmdb_api.Repository.PopularMoviesRepository

import com.example.tmdb_api.ViewModel.TMDB_ViewModel
import com.example.tmdb_api.databinding.ActivityTmdbDataDisplayBinding

class TMDB_DATA_Display_Activity : AppCompatActivity() {
    lateinit var binding: ActivityTmdbDataDisplayBinding

    lateinit var factory: TMDB_Factory
    lateinit var viewModel: TMDB_ViewModel
    lateinit var adapter: Movie_Data_RecyclerView_Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this , R.layout.activity_tmdb_data_display)

       factory = TMDB_Factory(PopularMoviesRepository("4da2ce878649bbad5b1ad09442ef2095")
       )
       viewModel = ViewModelProvider(this, factory)[TMDB_ViewModel::class.java]
       binding.lifecycleOwner = this

        //binding.recyclerViewMovie.layoutManager = LinearLayoutManager(this)

        binding.recyclerViewMovie.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerViewMovie.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)

        viewModel.getPopularMovie().observe(this) {
            adapter = Movie_Data_RecyclerView_Adapter(it, this)
            binding.recyclerViewMovie.adapter = adapter
            adapter.notifyDataSetChanged()
        }

    }
}