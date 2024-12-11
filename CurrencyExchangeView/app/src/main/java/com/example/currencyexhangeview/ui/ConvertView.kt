package com.example.currencyexhangeview.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier


@Composable
fun ConvertView(currencies: Map<String, String>, exchangeRates: Map<String, Double>) {
    var fromCurrency by remember { mutableStateOf("") }
    var toCurrency by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf(TextFieldValue("")) }
    val convertedAmount = remember(fromCurrency, toCurrency, amount.text) {
        amount.text.toDoubleOrNull()?.let {
            (exchangeRates[toCurrency] ?: 1.0) / (exchangeRates[fromCurrency] ?: 1.0) * it
        }
    }

    Column(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
        DropdownMenuSelector(
            label = "From Currency",
            items = currencies.keys.toList(),
            selected = fromCurrency,
            onSelectedChange = { fromCurrency = it }
        )

        Spacer(modifier = Modifier.height(8.dp))

        DropdownMenuSelector(
            label = "To Currency",
            items = currencies.keys.toList(),
            selected = toCurrency,
            onSelectedChange = { toCurrency = it }
        )

        Spacer(modifier = Modifier.height(8.dp))

        BasicTextField(
            value = amount,
            onValueChange = { amount = it },
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                Box(modifier = Modifier.padding(8.dp)) {
                    if (amount.text.isEmpty()) Text("Enter Amount")
                    innerTextField()
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Converted Amount: ${convertedAmount?.toString() ?: ""}")
    }
}