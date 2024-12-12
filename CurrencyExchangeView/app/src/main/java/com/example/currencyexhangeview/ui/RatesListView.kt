package com.example.currencyexhangeview.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.currencyexhangeview.viewmodel.CurrencyViewModel

@Composable
fun RatesListView(viewModel: CurrencyViewModel) {
    val currencies = viewModel.currencies
    val exchangeRates = viewModel.exchangeRates

    var selectedCurrency by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        DropdownMenuSelector(
            items = currencies.toList(),
            selected = currencies[selectedCurrency]?:"",
            onSelectedChange = { selectedCurrency = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        RatesTableView(currencies, exchangeRates, selectedCurrency)
    }
}
