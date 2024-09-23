package com.example.myscaffoldexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.myscaffoldexample.ui.MyScaffoldExample
import com.example.myscaffoldexample.ui.PreviewMyScaffoldExample

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewMyScaffoldExample()
        }
    }
}
