package com.example.tmdb_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.tmdb_api.Adapter_TMDB.Popular_TVSHOW_Recycler_View_Adapter
import com.example.tmdb_api.Factory.Popular_TVSHOW_Factory
import com.example.tmdb_api.Repository.Popular_TVSHOW_Repository
import com.example.tmdb_api.ViewModel.Person_ViewModel
import com.example.tmdb_api.databinding.ActivityPersonDataBinding

class Person_data : AppCompatActivity() {
    lateinit var binding: ActivityPersonDataBinding
    private lateinit var factory: Popular_TVSHOW_Factory
    private lateinit var viewModel: Person_ViewModel
    private lateinit var adapter2:Popular_TVSHOW_Recycler_View_Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this , R.layout.activity_person_data)

        factory = Popular_TVSHOW_Factory(Popular_TVSHOW_Repository("4da2ce878649bbad5b1ad09442ef2095"))

        viewModel = ViewModelProvider(this, factory)[Person_ViewModel::class.java]

        binding.lifecycleOwner = this

        binding.personRecyclerview.layoutManager = GridLayoutManager(this, 2)
        binding.personRecyclerview.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)

        viewModel.getPopularPerson().observe(this) {
            adapter2 = Popular_TVSHOW_Recycler_View_Adapter(it, this)
            binding.personRecyclerview.adapter = adapter2
            adapter2.notifyDataSetChanged()
        }
    }
}