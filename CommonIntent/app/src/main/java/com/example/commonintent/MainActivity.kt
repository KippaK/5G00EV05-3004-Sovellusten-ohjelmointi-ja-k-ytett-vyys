package com.example.commonintent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.commonintent.ui.theme.CommonIntentTheme
import com.example.commonintent.ui.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CommonIntentTheme {
                CommonIntent(context = this)
            }
        }
    }
}
