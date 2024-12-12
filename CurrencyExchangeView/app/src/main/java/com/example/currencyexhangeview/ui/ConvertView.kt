package com.example.currencyexhangeview.ui

import android.icu.text.DecimalFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.example.currencyexhangeview.viewmodel.CurrencyViewModel

@Composable
fun ConvertView(viewModel: CurrencyViewModel) {
    val currencies = viewModel.currencies
    val exchangeRates = viewModel.exchangeRates

    var fromCurrency by remember { mutableStateOf("") }
    var toCurrency by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf(TextFieldValue("")) }
    val convertedAmount = remember(fromCurrency, toCurrency, amount.text) {
        amount.text.toDoubleOrNull()?.let {
            val fromRate = (exchangeRates[fromCurrency] as? Number)?.toDouble() ?: 1.0
            val toRate = (exchangeRates[toCurrency] as? Number)?.toDouble() ?: 1.0
            (toRate / fromRate) * it
        }
    }

    val decimalFormat = DecimalFormat("#,##0.##########")

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.secondaryContainer),
    ) {
        item {
            DropdownMenuSelector(
                items = currencies.toList(),
                selected = currencies[fromCurrency] ?: "",
                onSelectedChange = { fromCurrency = it }
            )
        }
        item {
            BasicTextField(
                value = amount,
                onValueChange = { amount = it },
                textStyle = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .border(
                        1.dp,
                        MaterialTheme.colorScheme.primaryContainer,
                        RoundedCornerShape(16.dp)
                    )
                    .padding(4.dp),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxSize()
                    ) {
                        if (amount.text.isEmpty()) Text(
                            "0",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = MaterialTheme.colorScheme.onSecondaryContainer
                            ),
                            modifier = Modifier.fillMaxSize()
                        )
                        innerTextField()
                    }
                }
            )
        }
        item {
            DropdownMenuSelector(
                items = currencies.toList(),
                selected = currencies[toCurrency] ?:"",
                onSelectedChange = { toCurrency = it }
            )
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .border(
                        1.dp,
                        MaterialTheme.colorScheme.primaryContainer,
                        RoundedCornerShape(16.dp)
                    )
                    .padding(4.dp)
            ) {
                Text(
                    convertedAmount?.let { decimalFormat.format(it) } ?: "0",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    ),
                    modifier = Modifier.padding(8.dp).fillMaxSize()
                )
            }
        }
    }
}