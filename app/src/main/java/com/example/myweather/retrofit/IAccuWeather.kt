package com.example.myweather.retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import com.example.myweather.FiveDayForecast
interface IAccuWeather {

    @GET("forecasts/v1/daily/5day/{locationKey}")
    suspend fun getFiveDayForecast(
        @Path("locationKey") locationKey: String?,
        @Query("apikey") apiKey: String?,
        @Query("metric") metric: Boolean
    ): FiveDayForecast?

}