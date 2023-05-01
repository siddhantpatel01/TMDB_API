package com.example.tmdb_api.Adapter_TMDB

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb_api.Model.PopularMovies_Model
import com.example.tmdb_api.R
import com.example.tmdb_api.databinding.PopularMovieDataLayoutBinding
import com.example.tmdb_api.recycler_view_listner

class Movie_Data_RecyclerView_Adapter(private val movielist: List<PopularMovies_Model>,
                                      private var context: Context,private val onItemClickListener:recycler_view_listner
) : RecyclerView.Adapter<Movie_Data_RecyclerView_Adapter.MovieDataViewHolder>()  {


   // private lateinit var onItemClickListener: recycler_view_listner

    inner class MovieDataViewHolder(var binding: PopularMovieDataLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieDataViewHolder {
        var view: View? = LayoutInflater.from(parent.context)
            .inflate(R.layout.popular_movie_data_layout, parent, false)
        var binding: PopularMovieDataLayoutBinding = DataBindingUtil.bind(view!!)!!
        return MovieDataViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movielist.size
    }

    override fun onBindViewHolder(holder: MovieDataViewHolder, position: Int) {
        val movie = movielist[position]

        holder.binding.apply {
            var movietitle = movie.title
            var movieposter = movie.poster_path
            val urlpath = "https://image.tmdb.org/t/p/w500//${movieposter}"
            movieTextView.text = movietitle
            Glide.with(context).load(urlpath)
                .placeholder(R.drawable.baseline_person_24)
                .error(R.drawable.ic_launcher_foreground)
                .into(movieImageView)


            holder.itemView.setOnClickListener() {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position,movielist[position])
                }
            }



        }
    }


}