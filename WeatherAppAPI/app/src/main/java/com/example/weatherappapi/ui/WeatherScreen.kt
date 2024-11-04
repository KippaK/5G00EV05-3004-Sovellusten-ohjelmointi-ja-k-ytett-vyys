package com.example.weatherappapi.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherappapi.viewmodel.WeatherViewModel

@Composable
fun WeatherScreen(viewModel: WeatherViewModel, city: String) {
    viewModel.fetchWeather(city)

    val weatherData by viewModel.weatherData

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        weatherData?.let { data ->
            Text("Weather in $city", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            Text("Description: ${data.weather[0].description}")
            Text("Temperature: ${data.main.temp}°C")
            Text("Wind Speed: ${data.wind.speed} m/s")
        } ?: run {
            Text("Loading weather data...")
        }
    }
}
