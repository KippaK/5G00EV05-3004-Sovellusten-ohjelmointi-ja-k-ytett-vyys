package com.example.weatherappapi.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherappapi.viewmodel.WeatherViewModel

@Composable
fun MainScreen() {
    val weatherViewModel: WeatherViewModel = viewModel()
    WeatherScreen(viewModel = weatherViewModel, city = "Helsinki")
}
