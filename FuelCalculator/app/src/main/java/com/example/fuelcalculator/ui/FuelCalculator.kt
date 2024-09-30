@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.fuelcalculator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.fuelcalculator.R
import com.example.fuelcalculator.ui.theme.AppTheme

@Composable
fun FuelCalculator() {
    AppTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = stringResource(R.string.app_name)) },
                    modifier = Modifier.background(MaterialTheme.colorScheme.primary)
                )
            }
        ) { padding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                FuelCalculatorScreen()
            }
        }
    }
}

@Composable
fun FuelCalculatorScreen() {
    var fuelPrice by rememberSaveable { mutableStateOf("") }
    var fuelConsumption by rememberSaveable { mutableStateOf("") }
    var distance by rememberSaveable { mutableStateOf("") }
    var totalCost by rememberSaveable { mutableStateOf<Double?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = fuelPrice,
            onValueChange = { fuelPrice = it },
            label = { Text(text = stringResource(id = R.string.fuel_price)) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = fuelConsumption,
            onValueChange = { fuelConsumption = it },
            label = { Text(text = stringResource(id = R.string.fuel_consumption)) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = distance,
            onValueChange = { distance = it },
            label = { Text(text = stringResource(R.string.distance)) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val price = fuelPrice.toDoubleOrNull() ?: 0.0
                val consumption = fuelConsumption.toDoubleOrNull() ?: 0.0
                val dist = distance.toDoubleOrNull() ?: 0.0
                totalCost = if (price > 0 && consumption > 0 && dist > 0) {
                    (price * consumption * dist) / 100
                } else {
                    null
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.calculate))
        }

        Spacer(modifier = Modifier.height(16.dp))

        totalCost?.let { cost ->
            Text(
                text = stringResource(R.string.total_cost, cost),
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFuelCalculator() {
    FuelCalculator()
}
