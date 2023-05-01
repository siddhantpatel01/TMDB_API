package com.example.tmdb_api.Adapter_TMDB

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb_api.Model.Popular_TVSHOW_Model
import com.example.tmdb_api.R
import com.example.tmdb_api.databinding.PopularTvshowlayoutBinding

class Popular_TVSHOW_Recycler_View_Adapter(
    private val tvshowlist: List<Popular_TVSHOW_Model>,
    private var context: Context
) : RecyclerView.Adapter<Popular_TVSHOW_Recycler_View_Adapter.PersonDataViewHolder>() {

    inner class PersonDataViewHolder(var binding: PopularTvshowlayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonDataViewHolder {
        val view: View? = LayoutInflater.from(parent.context)
            .inflate(R.layout.popular_tvshowlayout, parent, false)
        val binding: PopularTvshowlayoutBinding = DataBindingUtil.bind(view!!)!!
        return PersonDataViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return tvshowlist.size
    }
    override fun onBindViewHolder(holder: PersonDataViewHolder, position: Int) {
        val person = tvshowlist[position]
        holder.binding.apply {
            var personImageurl = person.poster_path
            var movietitle = person.original_name
            val urlpath = "https://image.tmdb.org/t/p/w500/${personImageurl}"
            tvshowTextView.text = movietitle
            Glide.with(context).load(urlpath).into(tvshowImageView)
        }
    }
}