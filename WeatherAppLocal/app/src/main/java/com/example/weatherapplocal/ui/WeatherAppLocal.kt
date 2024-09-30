package com.example.weatherapplocal.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.weatherapplocal.R

@Composable
fun WeatherAppLocal() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.app_name))

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.sunny),
            contentDescription = stringResource(id = R.string.sunny_description),
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = stringResource(id = R.string.weather_today))
        Text(text = stringResource(id = R.string.temperature))
        Text(text = stringResource(id = R.string.wind_speed))

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { /* TODO: Refresh functionality */ }) {
            Icon(imageVector = Icons.Default.Refresh, contentDescription = stringResource(id = R.string.refresh_button))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWeatherAppLocal() {
    WeatherAppLocal()
}
