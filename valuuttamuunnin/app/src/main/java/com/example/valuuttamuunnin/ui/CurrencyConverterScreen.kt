package com.example.valuuttamuunnin.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CurrencyConverterScreen() {
    var amount by remember { mutableStateOf("") }
    var convertedAmount by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Valuuttamuunnin", style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Syötä summa") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        ConverterButton(onClick = {
            convertedAmount = "Muunnettu summa: ${amount}€"
        })

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = convertedAmount)
    }
}
