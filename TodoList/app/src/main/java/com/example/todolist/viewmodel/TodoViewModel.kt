package com.example.todolist.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.model.Todo
import com.example.todolist.network.RetrofitInstance
import kotlinx.coroutines.launch

class TodoViewModel : ViewModel() {
    private val _todos = mutableStateOf<List<Todo>>(emptyList())
    val todos get() = _todos

    init {
        fetchTodos()
    }

    private fun fetchTodos() {
        viewModelScope.launch {
            try {
                _todos.value = RetrofitInstance.api.getTodos()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
