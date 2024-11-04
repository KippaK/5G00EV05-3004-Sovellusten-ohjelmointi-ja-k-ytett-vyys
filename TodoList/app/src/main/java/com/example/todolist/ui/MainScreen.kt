package com.example.todolist.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.todolist.viewmodel.TodoViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun MainScreen(viewModel: TodoViewModel = viewModel()) {
    val todos = viewModel.todos.value

    LazyColumn {
        items(todos) { todo ->
            TodoItem(todo)
        }
    }
}
