package com.example.currencyexhangeview.ui

import android.icu.text.DecimalFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.currencyexhangeview.R

@Composable
fun RatesTableView(currencies: Map<String, String>, exchangeRates: Map<String, Double>, selectedCurrency: String) {
    val filteredRates = exchangeRates.entries.filter { it.key != selectedCurrency }
    val baseRate = exchangeRates[selectedCurrency] ?: 1.0

    val decimalFormat = DecimalFormat("#,##0.##########")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
        ) {
            Text(
                text = stringResource(R.string.currency),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f).padding(8.dp),
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Text(
                text = stringResource(R.string.rate),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f).padding(8.dp),
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }

        // Grid Content
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
        ) {
            // Data Rows
            filteredRates.forEach { (key, rate) ->
                item {
                    Text(
                        text = currencies[key].takeIf { !it.isNullOrEmpty() } ?: key,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(8.dp),
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
                item {
                    Text(
                        text = decimalFormat.format(rate / baseRate),
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(8.dp),
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }
        }
    }
}