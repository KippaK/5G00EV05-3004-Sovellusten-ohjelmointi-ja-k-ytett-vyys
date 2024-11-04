package com.example.weatherappapi.data

import retrofit2.http.GET
import retrofit2.http.Query


val API_KEY = "YOUR_API_KEY"

interface WeatherApi {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String = API_KEY,
        @Query("units") units: String = "metric"
    ): WeatherResponse
}
