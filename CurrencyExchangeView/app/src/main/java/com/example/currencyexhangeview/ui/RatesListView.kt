package com.example.currencyexhangeview.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.currencyexhangeview.viewmodel.CurrencyViewModel
import com.example.currencyexhangeview.R

@Composable
fun RatesListView(viewModel: CurrencyViewModel) {
    val currencies = viewModel.currencies
    val exchangeRates = viewModel.exchangeRates

    var selectedCurrency by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
        DropdownMenuSelector(
            label = stringResource(R.string.base_currency),
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