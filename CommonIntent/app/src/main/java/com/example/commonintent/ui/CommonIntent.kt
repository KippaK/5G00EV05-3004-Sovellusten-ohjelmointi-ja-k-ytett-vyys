package com.example.commonintent.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.AlarmClock
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CommonIntent(context: Context) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {
        Spacer(modifier = Modifier.height(36.dp))

        val googleUrl = "https://www.google.com"
        Button(
            onClick = { openBrowser(context, googleUrl) },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primaryContainer)
        ) {
            Text(
                text = "Open $googleUrl in Browser",
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }

        Button(
            onClick = { openMapLocation(context, "60.1699,24.9384") },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primaryContainer)
        ) {
            Text(
                text = "Show location on map",
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }

        Button(
            onClick = { setAlarm(context, "Alarm", 7, 30) },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primaryContainer)
        ) {
            Text(
                text = "Set an alarm",
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
        val phoneNumber = "123456789"
        Button(
            onClick = { dialPhoneNumber(context, phoneNumber) },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primaryContainer)
        ) {
            Text(
                text = "Dial $phoneNumber",
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
        Spacer(modifier = Modifier.height(36.dp))
    }
}

fun openBrowser(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse(url)
    }
    context.startActivity(intent)
}

fun openMapLocation(context: Context, location: String) {
    val geoUri = Uri.parse("geo:$location")
    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = geoUri
    }
    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    } else {
        Toast.makeText(context, "Maps is not installed", Toast.LENGTH_SHORT).show()
    }
}

fun setAlarm(context: Context, message: String, hour: Int, minutes: Int) {
    val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
        putExtra(AlarmClock.EXTRA_MESSAGE, message)
        putExtra(AlarmClock.EXTRA_HOUR, hour)
        putExtra(AlarmClock.EXTRA_MINUTES, minutes)
    }
    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    } else {
        Toast.makeText(context, "Alarm app is not installed", Toast.LENGTH_SHORT).show()
    }
}

fun dialPhoneNumber(context: Context, phoneNumber: String) {
    val intent = Intent(Intent.ACTION_DIAL).apply {
        data = Uri.parse("tel:$phoneNumber")
    }
    context.startActivity(intent)
}
