package com.example.myscaffoldexample.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffoldExample() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sovellus") }
            )
        },
        bottomBar = {
            BottomAppBar {
                // Voit lisätä alavalikon elementit tähän
                Text("Alavalikko")
            }
        }
    ) { innerPadding ->
        // Tässä on keskellä oleva sisältö
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Tervetuloa sovellukseen!")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /* TODO: Toiminnallisuus */ }) {
                Text("Klikkaa minua")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyScaffoldExample() {
    MyScaffoldExample()
}
