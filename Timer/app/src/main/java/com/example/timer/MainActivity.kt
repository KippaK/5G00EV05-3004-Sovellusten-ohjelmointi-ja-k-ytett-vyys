package com.example.timer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.timer.ui.TimerScreen
import com.example.timer.viewmodel.TimerViewModel
import com.example.timer.ui.theme.TimerTheme

class MainActivity : ComponentActivity() {
    private val timerViewModel: TimerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimerTheme {
                TimerScreen(timerViewModel)
            }
        }
    }
}
