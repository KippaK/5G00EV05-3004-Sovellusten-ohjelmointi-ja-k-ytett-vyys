package com.example.jetpackcomposestarter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val GLOBAL_FONT_SIZE_MAIN = 32.sp
val GLOBAL_ROUNDED_CORNER_RAD = 12.dp
val GLOBAL_SPACER_HEIGHT = 12.dp
val GLOBAL_BORDER_WIDTH = 2.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HelloApp() {
    var textState by remember { mutableStateOf("Hello World") }
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.LightGray
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ColumnText("My App")
            Spacer(modifier = Modifier.height(GLOBAL_SPACER_HEIGHT))
            ColumnText(textState, Modifier.weight(1f))
            Spacer(modifier = Modifier.height(GLOBAL_SPACER_HEIGHT))
            HelloButton(
                textState = textState,
                onTextChange = { newText -> textState = newText }
            )
        }
    }
}

@Composable
fun ColumnText(str: String, columnModifier: Modifier = Modifier) {
    var customModifier = Modifier
        .fillMaxWidth()
        .border(
            width = GLOBAL_BORDER_WIDTH,
            color = Color.Black,
            shape = RoundedCornerShape(GLOBAL_ROUNDED_CORNER_RAD))
        .clip(RoundedCornerShape(GLOBAL_ROUNDED_CORNER_RAD))
        .background(Color.White)
        .padding(12.dp)

    val combinedModifier = customModifier.then(columnModifier)

    Column(
        modifier = combinedModifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = str,
            fontSize = GLOBAL_FONT_SIZE_MAIN
        )
    }
}

@Composable
fun HelloButton(
    textState: String,
    onTextChange: (String) -> Unit
) {
    Button(
        onClick = {
            val newText = if (textState == "Hello World") {
                "Hello User"
            } else {
                "Hello World"
            }
            onTextChange(newText)
        },
        shape = RoundedCornerShape(GLOBAL_ROUNDED_CORNER_RAD),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Gray,
            contentColor = Color.Black
        ),
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = GLOBAL_BORDER_WIDTH,
                color = Color.Black,
                shape = RoundedCornerShape(GLOBAL_ROUNDED_CORNER_RAD))
    ) {
        Text(
            text = "Click To Say Hello",
            fontSize = GLOBAL_FONT_SIZE_MAIN
        )
    }
}
