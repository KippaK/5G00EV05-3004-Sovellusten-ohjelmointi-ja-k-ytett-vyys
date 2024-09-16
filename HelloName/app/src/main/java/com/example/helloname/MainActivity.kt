package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloName()
        }
    }
}

@Composable
fun HelloName() {
    Box(
        modifier = Modifier.fillMaxSize(), // Make the Box fill the screen
        contentAlignment = Alignment.Center // Center the content inside the Box
    ) {
        Text(text = "Antti Venetjoki")
    }
}