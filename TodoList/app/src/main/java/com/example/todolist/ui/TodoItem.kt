package com.example.todolist.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.todolist.model.Todo

@Composable
fun TodoItem(todo: Todo) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(if (todo.completed) Color.LightGray else Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = todo.completed,
            onCheckedChange = null
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = todo.title,
            style = TextStyle(
                textDecoration = if (todo.completed) TextDecoration.LineThrough else TextDecoration.None
            )
        )
    }
}
