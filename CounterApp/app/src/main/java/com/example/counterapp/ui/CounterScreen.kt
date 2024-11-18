package com.example.counterapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CounterScreen(counterViewModel: CounterViewModel = viewModel()) {
    val counter by counterViewModel.counter.observeAsState(0)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = counter.toString(), modifier = Modifier.padding(16.dp), fontSize = 32.sp)

        Button(
            onClick = { counterViewModel.increase() },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = "Kasvata")
        }

        Button(
            onClick = { counterViewModel.decrease() },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = "Pienennä")
        }
    }
}
