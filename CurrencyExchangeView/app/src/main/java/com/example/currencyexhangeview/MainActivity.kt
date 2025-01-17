package com.example.currencyexhangeview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.currencyexhangeview.ui.CurrencyExchangeView
import com.example.currencyexhangeview.ui.CurrencyExchangeViewPreview
import com.example.currencyexhangeview.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                CurrencyExchangeViewPreview()
            }
        }
    }
}