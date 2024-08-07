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
    // Variables to be used
    val LOGGING_TAG = "weatherDATA"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Thanks to https://stackoverflow.com/questions/46177133/
        // http-request-in-android-with-kotlin
        thread {
            val weather = try {
                buildURLForWeather()?.readText()
            } catch (e: Exception) {
                return@thread
            }
            runOnUiThread { consumeJson(weather) }
        }
    }

    private fun consumeJson(weatherJSON: String?) {
        if (weatherJSON != null) {
            val gson = Gson()
            val weatherData =
                gson.fromJson<ExampleJson2KtKotlin>(weatherJSON,
                    ExampleJson2KtKotlin::class.java)
            for(forecast in weatherData.DailyForecasts) {
                binding.tvWeather.append(
                    "Date: " +
                            forecast.Date?.substring(0, 10) +
                            " Min: " + forecast.Temperature?.Minimum?.Value +
                            " Max: " + forecast.Temperature?.Maximum?.Value +
                            "\n")
            }
        }
    }
}
