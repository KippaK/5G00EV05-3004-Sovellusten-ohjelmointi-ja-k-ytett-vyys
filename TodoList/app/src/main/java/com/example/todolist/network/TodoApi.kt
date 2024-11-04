package com.example.todolist.network

import com.example.todolist.model.Todo
import retrofit2.http.GET

interface TodoApi {
    @GET("todos")
    suspend fun getTodos(): List<Todo>
}
