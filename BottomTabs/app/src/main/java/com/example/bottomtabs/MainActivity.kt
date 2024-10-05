package com.example.bottomtabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.bottomtabs.ui.theme.BottomTabsTheme
import com.example.bottomtabs.ui.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BottomTabsTheme {
                PreviewNavBars()
            }
        }
    }
}