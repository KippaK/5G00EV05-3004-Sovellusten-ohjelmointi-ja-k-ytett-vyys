package com.example.currencyexhangeview.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.currencyexhangeview.viewmodel.CurrencyViewModel
import com.example.currencyexhangeview.R


@Composable
fun ConvertView(viewModel: CurrencyViewModel) {
    val currencies = viewModel.currencies
    val exchangeRates = viewModel.exchangeRates

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
            label = stringResource(R.string.from_currency),
            items = currencies.keys.toList(),
            selected = fromCurrency,
            onSelectedChange = { fromCurrency = it }
        )

        Spacer(modifier = Modifier.height(8.dp))

        DropdownMenuSelector(
            label = stringResource(R.string.to_currency),
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
                    if (amount.text.isEmpty()) Text(stringResource(R.string.enter_amount))
                    innerTextField()
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("${stringResource(R.string.converted_amount)}: ${convertedAmount?.toString() ?: ""}")
    }
}