package com.example.currencyexhangeview.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import com.example.currencyexhangeview.viewmodel.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.res.stringResource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.currencyexhangeview.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencyExchangeView () {
    val viewModel = remember { CurrencyViewModel() }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        stringResource(R.string.currency_exchange),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ) {
                Box(
                    contentAlignment = androidx.compose.ui.Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            val intent =
                                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.xe.com/"))
                            context.startActivity(intent)
                        }
                ) {
                    Text(
                        text = "${stringResource(R.string.open_website)}: https://www.xe.com/",
                        style = MaterialTheme.typography.labelLarge.copy(
                            textDecoration = TextDecoration.Underline
                        ),
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
        }
    ) { paddingValues ->
        var selectedView by remember { mutableIntStateOf(1) }

        Column(modifier = Modifier.padding(paddingValues)) {
            TabRow(
                selectedTabIndex = selectedView - 1) {
                Tab(
                    selected = selectedView == 1,
                    onClick = { selectedView = 1 },
                    modifier = Modifier.padding(0.dp, 8.dp)
                ) {
                    Text(
                        stringResource(R.string.convert),
                        style = MaterialTheme.typography.labelLarge
                    )
                }
                Tab(selected = selectedView == 2, onClick = { selectedView = 2 }) {
                    Text(
                        stringResource(R.string.rates_list),
                        style = MaterialTheme.typography.labelLarge
                    )
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