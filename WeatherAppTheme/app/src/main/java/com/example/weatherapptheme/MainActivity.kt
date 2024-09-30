package com.example.weatherapptheme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import com.example.weatherapptheme.ui.PreviewWeatherAppTheme
import com.example.weatherapptheme.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme(darkTheme = isSystemInDarkTheme(), dynamicColor = false) {
                PreviewWeatherAppTheme()
            }
        }
    }
}