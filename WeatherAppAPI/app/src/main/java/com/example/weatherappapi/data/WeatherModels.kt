package com.example.weatherappapi.data

data class WeatherResponse(
    val weather: List<Weather>,
    val main: Main,
    val wind: Wind
)

data class Weather(
    val description: String
)

data class Main(
    val temp: Float
)

data class Wind(
    val speed: Float
)
