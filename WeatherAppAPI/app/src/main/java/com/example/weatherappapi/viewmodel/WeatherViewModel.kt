package com.example.weatherappapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import com.example.weatherappapi.data.WeatherResponse
import com.example.weatherappapi.data.RetrofitInstance
import java.io.IOException

class WeatherViewModel : ViewModel() {
    private val _weatherData = mutableStateOf<WeatherResponse?>(null)
    val weatherData: State<WeatherResponse?> = _weatherData

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage

    fun fetchWeather(city: String) {
        viewModelScope.launch {
            try {
                // Nollaa aiemmat virheet ennen uutta hakua
                _errorMessage.value = null

                // Hakee säädatan
                val response = RetrofitInstance.api.getWeather(city)
                _weatherData.value = response

            } catch (e: IOException) {
                // Verkkovirhe, esim. verkkoyhteysongelma
                _errorMessage.value = "Network error: Please check your internet connection."
            } catch (e: Exception) {
                // Muu virhe, kuten epäkelpo kaupungin nimi tai palvelinvirhe
                _errorMessage.value = "Failed to load weather data: ${e.message}"
            }
        }
    }
}
