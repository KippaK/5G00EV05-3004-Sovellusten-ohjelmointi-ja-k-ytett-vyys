package com.example.bottomtabs.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier

@Composable
fun ScreenWrapper(content: @Composable () -> Unit) {
    Column (
        modifier = Modifier.fillMaxSize(1f)
    ){
        Spacer(modifier = Modifier.height(100.dp).fillMaxWidth())
        content()
        Spacer(modifier = Modifier.height(128.dp).fillMaxWidth())
    }
}