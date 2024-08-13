package com.example.myweather

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myweather.ExampleJson2KtKotlin
import com.example.myweather.databinding.ActivityMainBinding
import com.google.gson.Gson
import kotlin.concurrent.thread

    class MainActivity : AppCompatActivity() {
        lateinit var binding: ActivityMainBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
        }
    }