package com.example.tmdb_api

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.tmdb_api.Adapter_TMDB.Movie_Data_RecyclerView_Adapter
import com.example.tmdb_api.Factory.TMDB_Factory
import com.example.tmdb_api.Model.PopularMovies_Model
import com.example.tmdb_api.Repository.PopularMoviesRepository
import com.example.tmdb_api.RoomDB.MovieDatabase
import com.example.tmdb_api.ViewModel.TMDB_ViewModel
import com.example.tmdb_api.databinding.ActivityTmdbDataDisplayBinding
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TMDB_DATA_Display_Activity : AppCompatActivity(){
    lateinit var binding: ActivityTmdbDataDisplayBinding

    lateinit var factory: TMDB_Factory
    var Positions: Int = 0
    lateinit var viewModel: TMDB_ViewModel
    lateinit var adapter: Movie_Data_RecyclerView_Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tmdb_data_display)

        factory = TMDB_Factory(
            PopularMoviesRepository(
                "4da2ce878649bbad5b1ad09442ef2095",
                MovieDatabase.getDatabase(this).getmovieDao()
            )
        )
        viewModel = ViewModelProvider(this, factory)[TMDB_ViewModel::class.java]
        binding.lifecycleOwner = this

        //adapter.setOnItemClickListener(this)
      //  binding.recyclerViewMovie.layoutManager = LinearLayoutManager(this)

        binding.recyclerViewMovie.layoutManager = GridLayoutManager(this, 2)
       // binding.recyclerViewMovie.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)


        CoroutineScope(Dispatchers.Main).launch {
           viewModel.getMovie().observe(this@TMDB_DATA_Display_Activity) {
            adapter = Movie_Data_RecyclerView_Adapter(it, this@TMDB_DATA_Display_Activity,object :recycler_view_listner{
                override fun onItemClick(position: Int, moviesModel: PopularMovies_Model) {
                    Toast.makeText(this@TMDB_DATA_Display_Activity, "chicked $position", Toast.LENGTH_SHORT).show()
                   // startActivity(Intent(this@TMDB_DATA_Display_Activity,movie_details_Activity::class.java))
                    Positions = position
                    val singleStudent= moviesModel
                    val intent = Intent(this@TMDB_DATA_Display_Activity,movie_details_Activity::class.java)
                    intent.putExtra(Keys.movieobject, Gson().toJson(singleStudent))
                    startActivity(intent)

                }

            })
            binding.recyclerViewMovie.adapter = adapter


        }
       }

    }



}