package com.example.valuuttamuunnin.ui

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ConverterButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = "Muunna")
    }
}
