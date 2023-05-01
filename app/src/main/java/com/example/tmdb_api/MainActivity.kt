package com.example.tmdb_api

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.tmdb_api.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    fun movies(view: View) {
        startActivity(Intent(this, TMDB_DATA_Display_Activity::class.java))
    }

    fun TVSHOW(view: View) {
        startActivity(Intent(this, popular_TV_Show_Activity::class.java))
    }

    fun popular_Person(view: View) {
        startActivity(Intent(this, Popular_Person_Activity::class.java))
    }
}