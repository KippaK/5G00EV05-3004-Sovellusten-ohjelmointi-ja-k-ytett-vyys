package com.example.currencyexhangeview.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RatesListView(currencies: Map<String, String>, exchangeRates: Map<String, Double>) {
    var selectedCurrency by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
        DropdownMenuSelector(
            label = "Base Currency",
            items = currencies.keys.toList(),
            selected = selectedCurrency,
            onSelectedChange = { selectedCurrency = it }
        )

        LazyColumn {
            exchangeRates.entries.filter { it.key != selectedCurrency }.forEach { (key, rate) ->
                item {
                    Text(
                        text = "${currencies[key]}: ${rate / (exchangeRates[selectedCurrency] ?: 1.0)}",
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}