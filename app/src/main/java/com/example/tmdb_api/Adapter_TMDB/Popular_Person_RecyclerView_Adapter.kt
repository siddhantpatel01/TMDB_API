package com.example.tmdb_api.Adapter_TMDB

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb_api.Model.Popular_Person_Model
import com.example.tmdb_api.R
import com.example.tmdb_api.databinding.PopularPersonItemLayoutBinding

class Popular_Person_RecyclerView_Adapter(private val personlist: List<Popular_Person_Model>,
                                          private var context: Context
): RecyclerView.Adapter<Popular_Person_RecyclerView_Adapter.PersonDataViewHolder>() {
    inner class PersonDataViewHolder(var binding: PopularPersonItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonDataViewHolder {
        var view: View? = LayoutInflater.from(parent.context)
            .inflate(R.layout.popular_person_item_layout, parent, false)
        var binding: PopularPersonItemLayoutBinding = DataBindingUtil.bind(view!!)!!
        return PersonDataViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return personlist.size
    }

    override fun onBindViewHolder(holder: PersonDataViewHolder, position: Int) {
        val person = personlist[position]

        holder.binding.apply {
            var persontitle = person.name
            var personposter = person.profile_path
            val urlpath = "https://image.tmdb.org/t/p/w500/${personposter}"
            personTextView.text = persontitle
            Glide.with(context).load(urlpath).into(personImageView)
        }
    }
}