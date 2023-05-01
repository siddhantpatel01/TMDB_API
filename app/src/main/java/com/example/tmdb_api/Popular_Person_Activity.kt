package com.example.tmdb_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdb_api.Adapter_TMDB.Popular_Person_RecyclerView_Adapter
import com.example.tmdb_api.Adapter_TMDB.Popular_TVSHOW_Recycler_View_Adapter
import com.example.tmdb_api.Factory.Popular_Person_Factory
import com.example.tmdb_api.Factory.Popular_TVSHOW_Factory
import com.example.tmdb_api.Repository.Popular_Person_Repository
import com.example.tmdb_api.Repository.Popular_TVSHOW_Repository
import com.example.tmdb_api.ViewModel.Popular_Person_View_Model
import com.example.tmdb_api.ViewModel.tvshow_ViewModel
import com.example.tmdb_api.databinding.ActivityPopularPersonBinding
import com.example.tmdb_api.databinding.ActivityPopularTvShowBinding

class Popular_Person_Activity : AppCompatActivity() {
    lateinit var binding: ActivityPopularPersonBinding
    private lateinit var factory: Popular_Person_Factory
    private lateinit var viewModel: Popular_Person_View_Model
    private lateinit var adapter3: Popular_Person_RecyclerView_Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this , R.layout.activity_popular_person)

        factory = Popular_Person_Factory(Popular_Person_Repository("4da2ce878649bbad5b1ad09442ef2095"))

        viewModel = ViewModelProvider(this, factory)[Popular_Person_View_Model::class.java]

        binding.lifecycleOwner = this

        binding.personRecyclerview.layoutManager = LinearLayoutManager(this)

        viewModel.getPopularperson().observe(this) {
            adapter3 = Popular_Person_RecyclerView_Adapter(it, this)
            binding.personRecyclerview.adapter = adapter3
            adapter3.notifyDataSetChanged()
        }
    }
}