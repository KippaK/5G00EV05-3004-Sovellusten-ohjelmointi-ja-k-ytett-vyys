package com.example.weatherapplocal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.weatherapplocal.ui.PreviewWeatherAppLocal
import com.example.weatherapplocal.ui.theme.WeatherAppLocalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppLocalTheme {
                PreviewWeatherAppLocal()
            }
        }
    }
}