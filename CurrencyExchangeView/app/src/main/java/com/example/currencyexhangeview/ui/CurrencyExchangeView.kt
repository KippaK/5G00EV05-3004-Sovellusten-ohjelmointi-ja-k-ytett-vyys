package com.example.currencyexhangeview.ui

import androidx.compose.foundation.background
import com.example.currencyexhangeview.viewmodel.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.res.stringResource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.currencyexhangeview.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencyExchangeView () {
    val viewModel = remember { CurrencyViewModel() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        stringResource(
                            R.string.currency_exchange
                        ),
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { paddingValues ->
        var selectedView by remember { mutableStateOf(1) }

        Column(modifier = Modifier.padding(paddingValues)) {
            TabRow(selectedTabIndex = selectedView - 1) {
                Tab(selected = selectedView == 1, onClick = { selectedView = 1 }) {
                    Text(stringResource(R.string.convert))
                }
                Tab(selected = selectedView == 2, onClick = { selectedView = 2 }) {
                    Text(stringResource(R.string.rates_list))
                }
            }

            when (selectedView) {
                1 -> ConvertView(viewModel)
                2 -> RatesListView(viewModel)
            }
        }
    }

}

@Preview
@Composable
fun CurrencyExchangeViewPreview () {
    CurrencyExchangeView()
}