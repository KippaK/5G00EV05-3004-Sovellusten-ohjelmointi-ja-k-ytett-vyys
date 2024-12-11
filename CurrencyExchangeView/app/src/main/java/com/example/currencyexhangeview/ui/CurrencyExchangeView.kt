package com.example.currencyexhangeview.ui

import com.example.currencyexhangeview.viewmodel.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.collectAsState

@Composable
fun CurrencyExchangeView () {
    val viewModel = remember { CurrencyViewModel() }
    val currencies by viewModel.currencies.collectAsState(initial = emptyMap())
    val exchangeRates by viewModel.exchangeRates.collectAsState(initial = emptyMap())

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Currency Exchange") })
        }
    ) { paddingValues ->
        var selectedView by remember { mutableStateOf(1) }

        Column(modifier = Modifier.padding(paddingValues)) {
            TabRow(selectedTabIndex = selectedView - 1) {
                Tab(selected = selectedView == 1, onClick = { selectedView = 1 }) {
                    Text("Convert")
                }
                Tab(selected = selectedView == 2, onClick = { selectedView = 2 }) {
                    Text("Rates List")
                }
            }

            when (selectedView) {
                1 -> ConvertView(currencies, exchangeRates)
                2 -> RatesListView(currencies, exchangeRates)
            }
        }
    }

}

@Preview
@Composable
fun CurrencyExchangeViewPreview () {
    CurrencyExchangeView()
}